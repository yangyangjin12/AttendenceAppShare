package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
    }
    public void goSecond(View v){
        //Intent去设置要跳转的页面
        Intent intent = new Intent(this, MainActivity2.class);
        //跳转
        startActivity(intent);
    }
}

