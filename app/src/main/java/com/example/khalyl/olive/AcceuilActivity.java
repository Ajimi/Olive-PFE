package com.example.khalyl.olive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.khalyl.olive.utils.Utility;

import java.util.ArrayList;

public class AcceuilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        ArrayList<WhatData> items = Utility.getData(this);
        WhatWeDoAdapter itemsAdapter =
                new WhatWeDoAdapter(this, items);

        ListView listView = (ListView) findViewById(R.id.whatListView);
        listView.setAdapter(itemsAdapter);

        ArrayList<ProductData> products = Utility.getProducts(this);
        ProductAdapter productAdapter =
                new ProductAdapter(this, products);

        ListView lv = (ListView) findViewById(R.id.productListView);
        lv.setAdapter(productAdapter);
    }
}
