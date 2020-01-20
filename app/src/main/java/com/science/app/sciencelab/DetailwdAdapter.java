package com.science.app.sciencelab;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class DetailwdAdapter extends CursorAdapter {
     public DetailwdAdapter(Context context, Cursor c) {
        super(context, c, 1);
    }

    ImageView image;
     TextView title,description;
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_detailes,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        image=view.findViewById(R.id.iv_item);
         title=view.findViewById(R.id.tv_title);
         description=view.findViewById(R.id.tv_details);

        int image_tv =cursor.getInt(cursor.getColumnIndex("image"));
        String title_tv =cursor.getString(cursor.getColumnIndex("title"));
        String details_tv =cursor.getString(cursor.getColumnIndex("details"));

        image.setImageResource(image_tv);
        title.setText(title_tv);
        description.setText(details_tv);

    }
}
