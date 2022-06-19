package com.example.shiyan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateTable extends AppCompatActivity {

    private MyDatabase myDatabase;
    private MyDatabase myDatabase1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_table);

        myDatabase = new MyDatabase(this,"library",null,1);
        Button create = findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabase.getWritableDatabase();
            }
        });

        myDatabase1 = new MyDatabase(this,"library",null,2);
        Button add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = myDatabase1.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始添加默认书别类型
                values.put("category_name","管理类");
                values.put("category_code",12138);
                db.insert("Category",null,values);
                values.clear();
                values.put("category_name","故事类");
                values.put("category_code",12139);
                db.insert("Category",null,values);
                values.clear();
            }
        });
        Button insert = findViewById(R.id.addbook);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(CreateTable.this,InsertActivity.class);
//                startActivity(intent);
                SQLiteDatabase db = myDatabase1.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("author","haha");
                values.put("price",25.50);
                values.put("pages",520);
                values.put("name","不会带团队就只能自己干到死");
                values.put("category_id",1);
                db.insert("Book",null,values);
                values.clear();
                values.put("author","tom");
                values.put("price",32.50);
                values.put("pages",36);
                values.put("name","公主是怎么挖鼻屎的");
                values.put("category_id",2);
                db.insert("Book",null,values);
                values.clear();
                values.put("author","Jerry");
                values.put("price",42.30);
                values.put("pages",234);
                values.put("name","猫和老鼠");
                values.put("category_id",2);
                db.insert("Book",null,values);
                values.clear();
            }
        });
    }
}