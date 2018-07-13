package com.example.seowoo.instagram.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.seowoo.instagram.R;
import com.example.seowoo.instagram.Utils.MyOnclickListener;
import com.example.seowoo.instagram.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    LinearLayoutManager linearLayoutManager;
    private Context mContext;
    MyAdapter adapter;
    private static final int ACTIVITY_NUM = 4;
    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;
    private RecyclerView mRecyclerView;
    private LinearLayout parent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);

        mContext = AccountSettingsActivity.this;
        Log.d(TAG, "onCreate: started");
        mViewPager = (ViewPager)findViewById(R.id.container);
        mRelativeLayout = findViewById(R.id.relLayout1);
        mRecyclerView = findViewById(R.id.lvAccountSettings);
        parent = findViewById(R.id.parent);

        setupSettingsList();
        setupFragments();

        //setup the backarrow for navigation back to "ProfileActivity"
        ImageView backArrow = (ImageView)findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: navigation back to 'ProfileActivity'");
                finish();
            }
        });
    }

    private void setupFragments(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out));

    }

    private void setViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigating to fragment #: " + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupSettingsList(){
        Log.d(TAG, "setupSettingsList: initializing 'Acount Settings' list.");
        RecyclerView listView = findViewById(R.id.lvAccountSettings);

//        ArrayList<String> options = new ArrayList<>();
//        options.add(getString(R.string.edit_profile)); fragment 0
//        options.add(getString(R.string.sign_out)); fragment 1

        //ArrayAdapter adapter = new ArrayAdapter(mContext, android.R.layout.simple_list_item_1, options);
        linearLayoutManager = new LinearLayoutManager(this);
        listView.setHasFixedSize(true); //각 아이템이 보여지는 것을 일정하게
        listView.setLayoutManager(linearLayoutManager);

        ArrayList<ItemForm> options = new ArrayList<>();
        options.add(new ItemForm(getString(R.string.edit_profile)));
        options.add(new ItemForm(getString(R.string.sign_out)));

        adapter = new MyAdapter(mContext,options,mRecyclerView,parent);
        listView.setAdapter(adapter);


    }

}
