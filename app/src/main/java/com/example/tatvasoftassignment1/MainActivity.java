package com.example.tatvasoftassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    Button topViewBtn;
    Button centerViewBtn;
    Button bottomViewBtn;
    TextView lv1,lv2,rv1,rv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topViewBtn =(Button)findViewById(R.id.topViewBtn);
        centerViewBtn = (Button)findViewById(R.id.centerViewBtn);
        bottomViewBtn = (Button)findViewById(R.id.bottomViewBtn);
        lv1 = (TextView) findViewById(R.id.lv1);
        lv2 = (TextView) findViewById(R.id.lv2);
        rv1 = (TextView) findViewById(R.id.rv1);
        rv2 = (TextView) findViewById(R.id.rv2);
    }



    public void clickTopViewBtn(View view) {

        topViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv2.setVisibility(View.INVISIBLE);
                rv2.setVisibility(View.INVISIBLE);
            }
        });

    }

    public void clickCenterViewBtn(View view) {

        centerViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv2.setVisibility(View.VISIBLE);
                rv2.setVisibility(View.VISIBLE);
                lv1.setVisibility(View.VISIBLE);
                rv1.setVisibility(View.VISIBLE);
            }
        });
    }

    public void clickBottomViewBtn(View view) {

        bottomViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv1.setVisibility(View.INVISIBLE);
                rv1.setVisibility(View.INVISIBLE);
            }
        });
    }


}