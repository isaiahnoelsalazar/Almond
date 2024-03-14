package com.salazarisaiahnoel.customs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.Objects;

public class RoundedAlertDialog {
    Context context;
    LayoutInflater li;
    View v;
    AlertDialog.Builder adb;
    AlertDialog ad;
    Button leftButton, rightButton;
    ScrollView sv;

    public RoundedAlertDialog(Context context){
        this.context = context;
    }

    public void create(String title){
        li = LayoutInflater.from(context);
        v = li.inflate(R.layout.rounded_alert_dialog_layout, null);
        final TextView texttitle = v.findViewById(R.id.rounded_alert_dialog_title);
        sv = v.findViewById(R.id.rounded_alert_dialog_view);
        adb = new AlertDialog.Builder(context)
                .setView(v);
        texttitle.setText(title);
    }

    public void addView(View view){
        sv.addView(view);
    }

    public void setupLeftButton(String text){
        leftButton = v.findViewById(R.id.rounded_alert_dialog_left_button);
        leftButton.setText(text);
        leftButton.setVisibility(View.VISIBLE);
    }

    public void setupLeftButtonOnClick(View.OnClickListener onClick){
        leftButton.setOnClickListener(onClick);
    }

    public void setupRightButtonOnClick(View.OnClickListener onClick){
        rightButton.setOnClickListener(onClick);
    }

    public void setupRightButton(String text){
        rightButton = v.findViewById(R.id.rounded_alert_dialog_right_button);
        rightButton.setText(text);
        rightButton.setVisibility(View.VISIBLE);
    }

    public void show(){
        ad = adb.create();
        Objects.requireNonNull(ad.getWindow()).getDecorView().setBackgroundColor(Color.TRANSPARENT);
        ad.show();
    }

    public void hide(){
        ad.cancel();
    }
}
