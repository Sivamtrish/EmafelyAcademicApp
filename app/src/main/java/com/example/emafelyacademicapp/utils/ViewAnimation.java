package com.example.emafelyacademicapp.utils;

import android.view.View;

public class ViewAnimation {
    public static void fadeOut(final View v) {
        ViewAnimation.fadeOut(v, null);
    }

    public static void fadeOut(final View... views) {
        for (View view : views) {
            fadeOut(view, null);
        }
    }


    public static void fadeIn(final View v) {
        ViewAnimation.fadeIn(v, null);
    }

    public static void fadeIn(final View... views) {
        for (View view : views) {
            fadeIn(view, null);
        }
    }
}
