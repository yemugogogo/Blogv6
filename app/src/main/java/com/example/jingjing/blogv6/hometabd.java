package com.example.jingjing.blogv6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

class hometabd extends RelativeLayout {
    private Context myContext;
    private Context mainContext;
    private View view02;
    public hometabd(Context context) {
        super(context);
        myContext = context;
        view02 = LayoutInflater.from(myContext).inflate(R.layout.hometabd, null);
        addView(view02);
    }
}
