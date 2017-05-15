package com.example.khalyl.olive;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

/**
 * Created by K H A L Y L on 16/04/2017.
 */

public class ProductItems extends AbstractItem<ProductItems, ProductItems.ViewHolder> {
    public String mImage;
    public String mDescription;
    public String mPrice;
    public String mName;

    public ProductItems withImage(String image) {
        this.mImage = image;
        return this;
    }

    public ProductItems withName(String name) {
        this.mName = name;
        return this;
    }

    public ProductItems withDescription(String description) {
        this.mDescription = description;
        return this;
    }

    public ProductItems withPrice(String price) {
        this.mPrice = price;
        return this;
    }

    @Override
    public int getType() {
        return R.id.fastadapter_sampleitem_id;
    }

    //The layout to be used for this type of item
    @Override
    public int getLayoutRes() {
        return R.layout.list_item;
    }

    //The logic to bind your data to the view
    @Override
    public void bindView(ViewHolder viewHolder, List<Object> payloads) {
        //call super so the selection is already handled for you
        super.bindView(viewHolder, payloads);

        viewHolder.name.setText(mName);
//        viewHolder.image.setImageDrawable(mImage + ".jpg");
        viewHolder.description.setText(mDescription);
        viewHolder.price.setText(mPrice);
    }

    //reset the view here (this is an optional method, but recommended)
    @Override
    public void unbindView(ViewHolder holder) {
        super.unbindView(holder);
        holder.name.setText(null);
        holder.description.setText(null);
    }

    //Init the viewHolder for this Item
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    //The viewHolder used for this item. This viewHolder is always reused by the RecyclerView so scrolling is blazing fast
    protected static class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView price;
        protected ImageView image;
        protected TextView description;
        protected Button button;
        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.product_name);
            price = (TextView) view.findViewById(R.id.product_price);
            description = (TextView) view.findViewById(R.id.product_description);
            image = (ImageView) view.findViewById(R.id.product_picture);
        }
    }
}
