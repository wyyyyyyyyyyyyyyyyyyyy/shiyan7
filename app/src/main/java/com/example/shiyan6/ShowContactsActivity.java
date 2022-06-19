package com.example.shiyan6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ShowContactsActivity extends AppCompatActivity {

    private String newName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);

        //查询全部数据
        Button select = findViewById(R.id.selectall);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("content://com.example.databasetest.provider/contacts");
                Cursor cursor = getContentResolver().query(uri,null,null,
                        null,null);
                if (cursor!=null){
                    while(cursor.moveToNext()){
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone"));
                        @SuppressLint("Range") String sex = cursor.getString(cursor.getColumnIndex("sex"));

                        Log.d("ShowContactsActivity","联系人姓名："+name);
                        Log.d("ShowContactsActivity","联系人电话："+phone);
                        Log.d("ShowContactsActivity","联系人性别："+sex);
                    }
                    cursor.close();
                }
            }
        });

        //查询单个人数据
        Button select1 = findViewById(R.id.selectone);
        select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newName = "tom";
                Uri uri = Uri.parse("content://com.example.databasetest.provider/contacts/1");
                Cursor cursor = getContentResolver().query(uri,null,"name=?",
                        new String[]{newName},null);
                if (cursor!=null){
                    while (cursor.moveToNext()) {
                        @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                        @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex("phone"));
                        @SuppressLint("Range") String sex = cursor.getString(cursor.getColumnIndex("sex"));
                        Log.d("ShowContactsActivity", "联系人姓名：" + name);
                        Log.d("ShowContactsActivity", "联系人电话：" + phone);
                        Log.d("ShowContactsActivity", "联系人性别：" + sex);
                        cursor.close();
                    }
                }
                else Log.d("ShowContactsActivity","输入错误！");

            }
        });
    }
}