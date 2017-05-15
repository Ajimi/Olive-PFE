package com.example.khalyl.olive;

import android.content.Context;

/**
 * Created by selim on 5/14/2017.
 */

public class WhatData {

    int mResourceId;

    public int getmResourceId() {
        return mResourceId;
    }

    public void setmResourceId(int mResourceId) {
        this.mResourceId = mResourceId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    String mTitle, mDescription;

    public WhatData(Context context, String resourceId , String title, String description){
        int mResourceId = context.getResources().getIdentifier(resourceId, null, context.getPackageName());
        mTitle = title;
        mDescription = description;
    }

}
