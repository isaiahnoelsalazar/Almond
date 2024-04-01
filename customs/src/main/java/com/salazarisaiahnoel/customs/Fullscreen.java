package com.salazarisaiahnoel.customs;

import android.app.Activity;
import android.view.View;
import android.view.WindowManager;

import java.util.Objects;

public class Fullscreen {
    public static void enableFullscreen(Activity activity){
        activity.getWindow().getDecorView().setSystemUiVisibility(WindowManager.LayoutParams.FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        Objects.requireNonNull(activity.getActionBar()).hide();
    }

    public static void disableFullscreen(Activity activity){
        activity.getWindow().getDecorView().setSystemUiVisibility(View.VISIBLE);
        Objects.requireNonNull(activity.getActionBar()).show();
    }
}
