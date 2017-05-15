package com.example.khalyl.olive;

/**
 * Created by selim on 5/14/2017.
 */

public class ProductData {
    private int mImage;
    String name;
    String price;

    public ProductData(int mImage, String name, String price) {
        this.mImage = mImage;
        this.name = name;
        this.price = price;
    }
    public ProductData(){

    }
    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
