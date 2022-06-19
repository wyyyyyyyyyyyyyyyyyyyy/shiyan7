package com.example.shiyan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        String pass = intent.getStringExtra("password");

        TextView username = findViewById(R.id.username1);
        TextView password = findViewById(R.id.password1);

        username.setText("用户名："+name);
        password.setText("密码："+pass);
    }
}