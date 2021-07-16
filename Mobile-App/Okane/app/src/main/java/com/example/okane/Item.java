package com.example.okane;

public class Item
{
    private int imageurl;

    public Item(int imageurl) {
        this.imageurl = imageurl;
    }

    public Item() {
    }

    public int getImageurl() {
        return imageurl;
    }

    public void setImageurl(int imageurl) {
        this.imageurl = imageurl;
    }
}
