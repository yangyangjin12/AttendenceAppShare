package com.example.application2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import cn.smssdk.EventHandler;

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

