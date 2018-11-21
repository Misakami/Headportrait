package com.example.misaka.headportrait;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class ButtomDilog {
    private Context context;
    private AlertDialog.Builder builder;
    private View view;
    private Button take_photo;
    private Button Album;
    private Button cancel;
    private AlertDialog dialog;

    public ButtomDilog(Context context) {
        this.context = context;
        builder =new AlertDialog.Builder(context);
        view = LayoutInflater.from(context).inflate(R.layout.layout_buttomstyle,null);
        take_photo = (Button) view.findViewById(R.id.take_photo);
        Album = (Button) view.findViewById(R.id.album);
        cancel = (Button) view.findViewById(R.id.cancel);
        dialog = new AlertDialog.Builder(context).create();
    }

    public void setTake_photo(View.OnClickListener listener){
        take_photo.setOnClickListener(listener);
    }
    public void setAlbum(View.OnClickListener listener){
        Album.setOnClickListener(listener);
    }
    public void show(){
        dialog.show();

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Window window =dialog.getWindow();
        window.setContentView(view);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        window.setGravity(Gravity.BOTTOM);
        window.setWindowAnimations(R.style.animation_buttom);
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
    }


    public void close(){
        dialog.dismiss();
    }
}
