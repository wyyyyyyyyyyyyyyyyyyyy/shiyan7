package com.example.shiyan6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.List;

public class BookAdapter extends ArrayAdapter<book> {
    private int resourceId;

    public BookAdapter(Context context, int resource,List<book> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent){
        book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        TextView author = view.findViewById(R.id.book_author);
        TextView price = view.findViewById(R.id.book_price);
        TextView pages = view.findViewById(R.id.book_pages);
        TextView name = view.findViewById(R.id.book_name);
        TextView category_id = view.findViewById(R.id.category_id);


        author.setText(book.getAuthor());
        price.setText(book.getPrice()+"");
        pages.setText(book.getPages()+"");
        name.setText(book.getName());
        category_id.setText(book.getCategory_id()+"");

        return view;
    }
}
