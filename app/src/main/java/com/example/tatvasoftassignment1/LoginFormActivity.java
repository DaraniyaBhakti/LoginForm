package com.example.tatvasoftassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shawnlin.numberpicker.NumberPicker;

import java.util.Locale;
import java.util.regex.Pattern;

import static android.content.ContentValues.TAG;
import static android.widget.Toast.*;

public class LoginFormActivity extends BaseActivity {

    EditText etUsername,etEmail,etPassword,etContactNo,etAge;
    Button btnSave;
    private int value;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        setupActionBar("Login Form");

        etUsername = (EditText)findViewById(R.id.etUsername);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etContactNo = (EditText)findViewById(R.id.etContactNo);
        etAge = (EditText)findViewById(R.id.etAge);
        btnSave = (Button)findViewById(R.id.btnSave);
        linearLayout=findViewById(R.id.linerLayout);


        etAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               numberPicker();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isValid())
                {
                    Toast.makeText(LoginFormActivity.this, "Valid Data", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginFormActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    boolean isValid(){

        boolean isValid=true;
        //Username
        if(TextUtils.isEmpty(etUsername.getText().toString())){
            isValid=false;
            etUsername.setError("Enter Username");
        }

        //Email
        if(TextUtils.isEmpty(etEmail.getText().toString())){
            isValid=false;
            etEmail.setError("Enter Email");
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches())
        {
            isValid=false;
            etEmail.setError("Enter Valid Email");
        }

        //Password
        if(TextUtils.isEmpty(etPassword.getText().toString())){
            isValid=false;
            etPassword.setError("Enter Password");
        }
        if(etPassword.getText().toString().length()<6){
            isValid=false;
            etPassword.setError("Password too Short.");
        }

        //Contact No.
        if(TextUtils.isEmpty(etContactNo.getText().toString())){
            isValid=false;
            etContactNo.setError("Enter Password");
        }
        if(etContactNo.getText().toString().length()<10){
            isValid=false;
            etContactNo.setError("Enter valid contact no.");
        }

        //Age
        if(TextUtils.isEmpty(etAge.getText().toString()))
        {
            etAge.setError("Select Age");
            isValid=false;
        }


        return isValid;
    }

    private void numberPicker( ){

        NumberPicker numberPicker = (NumberPicker) findViewById(R.id.number_picker);
        ViewGroup.LayoutParams params =linearLayout.getLayoutParams();

        params.height=300;

        linearLayout.setLayoutParams(params);
        numberPicker.setVisibility(View.VISIBLE);

// Set divider color
        numberPicker.setDividerColor(ContextCompat.getColor(this, R.color.colorPrimary));
        numberPicker.setDividerColorResource(R.color.colorPrimary);
// Set value
        numberPicker.setMaxValue(70);
        numberPicker.setMinValue(0);
        numberPicker.setValue(10);

// Set fading edge enabled
        numberPicker.setFadingEdgeEnabled(true);

// Set scroller enabled
        numberPicker.setScrollerEnabled(true);

// Set wrap selector wheel
        numberPicker.setWrapSelectorWheel(true);

// Set accessibility description enabled
        numberPicker.setAccessibilityDescriptionEnabled(true);

// OnClickListener
        numberPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Click on current value");
            }
        });

// OnValueChangeListener
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

               int valuePicker = numberPicker.getValue();

                Log.d(TAG, "Value =" +valuePicker);

            }
        });

// OnScrollListener
        numberPicker.setOnScrollListener(new NumberPicker.OnScrollListener() {
            @Override
            public void onScrollStateChange(NumberPicker picker, int scrollState) {
                if (scrollState == SCROLL_STATE_IDLE) {
                    Log.d(TAG, String.format(Locale.US, "newVal: %d", picker.getValue()));
                   value = picker.getValue();

                    etAge.setText(String.valueOf(value));
                    params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                    linearLayout.setLayoutParams(params);
                    numberPicker.setVisibility(View.GONE);
                }
            }
        });
        value=numberPicker.getValue();


    }
}