package com.example.seowoo.instagram.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.example.seowoo.instagram.Home.HomeActivity;
import com.example.seowoo.instagram.Likes.LikesActivity;
import com.example.seowoo.instagram.Profile.ProfileActivity;
import com.example.seowoo.instagram.R;
import com.example.seowoo.instagram.Search.SearchActivity;
import com.example.seowoo.instagram.Share.ShareActivity;
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

    public static void enableNavigation(final Context context, BottomNavigationViewEx view)
    {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.ic_house:
                        Intent intent = new Intent(context, HomeActivity.class);
                        context.startActivity(intent);
                        break;

                    case R.id.ic_search:
                        Intent intent2 = new Intent(context, SearchActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_circle:
                        Intent intent3 = new Intent(context, ShareActivity.class);
                        context.startActivity(intent3);
                        break;

                    case R.id.ic_alert:
                        Intent intent4 = new Intent(context, LikesActivity.class);
                        context.startActivity(intent4);
                        break;

                    case R.id.ic_android:
                        Intent intent5 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent5);
                        break;
                }
                return false;
            }
        });
    }
}
