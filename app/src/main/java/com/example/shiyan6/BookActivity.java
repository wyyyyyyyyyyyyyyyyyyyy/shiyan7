package com.example.shiyan6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    private List<book> bookList = new ArrayList<>();
    private MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        myDatabase = new MyDatabase(this,"library",null,2);
        SQLiteDatabase db = myDatabase.getWritableDatabase();
        Cursor cursor = db.query("Book",null,null,
                null,null,null,null);
        while(cursor.moveToNext()){
            @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex("author"));
            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
            @SuppressLint("Range") int pages = cursor.getInt(cursor.getColumnIndex("pages"));
            @SuppressLint("Range") double price = cursor.getDouble(cursor.getColumnIndex("price"));
            @SuppressLint("Range") int cageId = cursor.getInt(cursor.getColumnIndex("category_id"));

            book book = new book(author,price,pages,name,cageId);
            bookList.add(book);
        }
        cursor.close();
        BookAdapter adapter = new BookAdapter(BookActivity.this,
                R.layout.book_item,bookList);
        ListView listView = findViewById(R.id.bookList);
        listView.setAdapter(adapter);

        Button insert = findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this,InsertActivity.class);
                startActivity(intent);
            }
        });
    }
}