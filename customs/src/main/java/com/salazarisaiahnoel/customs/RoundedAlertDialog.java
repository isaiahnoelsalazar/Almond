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
    LayoutInflater layoutInflater;
    View dialogView;
    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    Button leftButton, rightButton;
    ScrollView scrollView;

    public RoundedAlertDialog(Context context){
        this.context = context;
    }

    public void create(String title){
        layoutInflater = LayoutInflater.from(context);
        dialogView = layoutInflater.inflate(R.layout.rounded_alert_dialog_layout, null);
        final TextView texttitle = dialogView.findViewById(R.id.rounded_alert_dialog_title);
        scrollView = dialogView.findViewById(R.id.rounded_alert_dialog_view);
        scrollView.setVisibility(View.GONE);
        builder = new AlertDialog.Builder(context)
                .setView(dialogView);
        texttitle.setText(title);
    }

    public void addView(View view){
        scrollView.setVisibility(View.VISIBLE);
        scrollView.addView(view);
    }

    public void setupLeftButton(String text){
        leftButton = dialogView.findViewById(R.id.rounded_alert_dialog_left_button);
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
        rightButton = dialogView.findViewById(R.id.rounded_alert_dialog_right_button);
        rightButton.setText(text);
        rightButton.setVisibility(View.VISIBLE);
    }

    public void show(){
        alertDialog = builder.create();
        Objects.requireNonNull(alertDialog.getWindow()).getDecorView().setBackgroundColor(Color.TRANSPARENT);
        alertDialog.show();
    }

    public void hide(){
        alertDialog.cancel();
    }
}
