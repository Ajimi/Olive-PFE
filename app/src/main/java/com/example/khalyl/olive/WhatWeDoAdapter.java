package com.example.khalyl.olive;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by selim on 5/14/2017.
 */

public class WhatWeDoAdapter extends ArrayAdapter<WhatData> {
    public WhatWeDoAdapter(@NonNull Context context, ArrayList<WhatData> data) {
        super(context, 0 , data);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        WhatData data = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_description, parent, false);
        }

        ImageView img = (ImageView) convertView.findViewById(R.id.img);
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView description = (TextView) convertView.findViewById(R.id.description);

        // img.setImageResource(data.getmResourceId());
        title.setText(data.getmTitle());
        description.setText(data.getmDescription());

        return convertView;
    }
}
