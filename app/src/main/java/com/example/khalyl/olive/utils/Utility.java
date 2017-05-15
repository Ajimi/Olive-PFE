package com.example.khalyl.olive.utils;

import android.content.Context;

import com.example.khalyl.olive.ProductData;
import com.example.khalyl.olive.ProductItems;
import com.example.khalyl.olive.WhatData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selim on 4/22/2017.
 */

public class Utility {
    private static Context mContext;

    private static String[] images = {"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};
    private static String[] title = {"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};
    private static String[] description = {"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};
    public static List<ProductItems> getDataFromJson(){
        ArrayList<ProductItems> item = new ArrayList<>();
        ProductItems m = new ProductItems().withName("Selim").withPrice("15.0").withDescription("mmqsjdqs");
        item.add(m);
        item.add(m);
        item.add(m);
        item.add(m);
        return item;
    }

    public static ArrayList<WhatData> getData(Context context) {

        ArrayList<WhatData> data = new ArrayList<>();
        String uri = "drawable/";
        for(int i = 0 ; i < Utility.images.length ; i++) {
            data.add(new WhatData(context, images[i], title[i], description[i]));
        }
        // int imageResource = R.drawable.icon;
        return data;
    }

    public static ArrayList<ProductData> getProducts(int i) {
        ArrayList<ProductData> data = new ArrayList<>();
        data.add(new ProductData());
        data.add(new ProductData());
        data.add(new ProductData());
        return data;
    }
}
