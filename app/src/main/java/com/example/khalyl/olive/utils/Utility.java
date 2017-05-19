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
//
//    private static String[] images = {"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};
//    private static String[] title = {"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};
//    private static String[] price = {"","","",};
    private static String[] description = {"image1.jpg","image2.jpg","image3.jpg","image4.jpg"};

    private static String[] images = {"virginia_0_25","virginia_0_5","virginia_0_75","virginia_1","virginia_3","virginia_5","virginia_organic_0_25","virginia_organic_0_5","virginia_organic_0_75","donia_fruity_0_25","donia_fruity_1","donia_mild_0_25","donia_mild_0_75"};
    private static String[] title = {"virgina 250 ML – Marasca","virginia 500 ML – Marasca","virginia 750 ML – Marasca","virginia 1L - Puglia"," 3 L- Bidon Métallique"," 5 L- Bidon Métallique","virginia bio 250 ML – Marasca","virginia bio 500 ML – Marasca","virginia bio 750 ML – Marasca"," 250 ML – WILLY","1 L – BERTOLLI","Mild 250 ML – WILLY", "Mild 750 ML – Marasca"};
    private static String[] price = {"10","10","10","10","10","10","10","10","10","10","10","10","10"};
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

    public static ArrayList<ProductData> getProducts(Context context) {
        ArrayList<ProductData> data = new ArrayList<>();
        for(int i = 0 ; i < Utility.images.length ; i++) {
            String uri = "drawable";
            int resID = context.getResources().getIdentifier(images[i], uri, context.getPackageName());
            data.add(new ProductData(resID, title[i], price[i]));
        }
        return data;
    }
}
