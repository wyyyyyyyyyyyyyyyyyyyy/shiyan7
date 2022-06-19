package com.example.shiyan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private MyDatabase myDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        EditText name = findViewById(R.id.shuming);
        EditText price = findViewById(R.id.jiage);
        EditText pages = findViewById(R.id.yeshu);
        EditText category = findViewById(R.id.shubiehao);
        EditText author = findViewById(R.id.zuozhe);
        Button submit = findViewById(R.id.submit);
        myDatabase = new MyDatabase(this,"library",null,2);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1 = name.getText().toString();
                String price1 = price.getText().toString();
                String pages1 = pages.getText().toString();
                String category1 = category.getText().toString();
                String author1 = author.getText().toString();
                if(name1!=null && price1!=null && pages1!=null && category1!=null
                && author1!=null){
                    SQLiteDatabase db = myDatabase.getWritableDatabase();
                    ContentValues values = new ContentValues();
                    values.put("author",author1);
                    values.put("price",Double.parseDouble(price1));
                    values.put("pages",Integer.parseInt(pages1));
                    values.put("name",name1);
                    values.put("category_id",Integer.parseInt(category1));
                    db.insert("Book",null,values);
                    values.clear();
                    Toast.makeText(InsertActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(InsertActivity.this,BookActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(InsertActivity.this, "不能有空的！", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}