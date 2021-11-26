package com.example.tatvasoftassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class LoginScreen extends BaseActivity {

    TextView tvTerms,tvFooter,tvRegister;
    Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        setTitle("Assignment 1");
        setupActionBar("Assignment 1");

        tvTerms=(TextView)findViewById(R.id.tvTerms);
        tvFooter=(TextView)findViewById(R.id.tvFooter);
        tvRegister=(TextView)findViewById(R.id.tvRegister);
        loginBtn = (Button)findViewById(R.id.loginBtn);

        String termsString = "By proceeding, you agree to our <b>Terms Of service</b> and <b>Privacy Policy</b>";
        tvTerms.setText(Html.fromHtml(termsString));

        String footerString = "An <b>e-Teaching</b> Service from School";
        tvFooter.setText(Html.fromHtml(footerString));

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this,MainActivity.class);
                startActivity(intent);
            }
        });
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this,LoginFormActivity.class);
                startActivity(intent);
            }
        });

    }
}