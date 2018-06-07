package com.example.seowoo.instagram.Utils;

import android.util.Log;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

/**
 * Created by seowoo on 2018-06-07.
 */

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx)
    {
        Log.d(TAG, "setupBottomNavigationView: Setting up BottomNavigationView");
        //Enable or disable click item animation(text scale and icon move animation in no item shifting mode). Default true
        bottomNavigationViewEx.enableAnimation(false);
        //Enable the shifting mode for each item. It will has a shift animation for item if true. Otherwise the item text always be shown. Default true when item count >3
        bottomNavigationViewEx.enableItemShiftingMode(false);
        //Enable the shifting mode for navigation. It will has a shift animation if true. Otherwise all items are the same width. Default true when item count > 3.
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }
}
