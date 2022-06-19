package com.example.shiyan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText name;
    private EditText password;
    private Button login;
    private CheckBox remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        name = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.passwordText);
        login = findViewById(R.id.login);
        remember = findViewById(R.id.remember);

        boolean isRemember = preferences.getBoolean("remember_password",false);

        if(isRemember){
            //将账号密码都设置到文本框
            String user = preferences.getString("name","");
            String pass = preferences.getString("password","");
            name.setText(user);
            password.setText(pass);
            remember.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String user = name.getText().toString();
                String pass = password.getText().toString();
                //如果账号是admin密码是123456则登陆成功
                if(user.equals("admin")&&pass.equals("123456")){
                    editor = preferences.edit();
                    if(remember.isChecked())//检查是否记住密码
                    {
                        editor.putBoolean("remember_password",true);
                        editor.putString("name",user);
                        editor.putString("password",pass);
                    }
                    else{
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this,SuccessActivity.class);
                    intent.putExtra("username",user);
                    intent.putExtra("password",pass);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "账号or密码错误！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}