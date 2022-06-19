package com.example.shiyan6;

public class book {
    private int id;
    private String author;
    private double price;
    private int pages;
    private String name;
    private int Category_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory_id() {
        return Category_id;
    }

    public void setCategory_id(int category_id) {
        Category_id = category_id;
    }

    public book(String author,double price,int pages,String name
            ,int Category_id){
        this.author=author;
        this.price=price;
        this.pages=pages;
        this.name=name;
        this.Category_id=Category_id;
    }

}
