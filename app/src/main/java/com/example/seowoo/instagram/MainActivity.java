package com.example.seowoo.instagram;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.seowoo.instagram.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, ProfileFragment.OnFragmentInteractionListener,LikesFragment.OnFragmentInteractionListener,SearchFragment.OnFragmentInteractionListener,ShareFragment.OnFragmentInteractionListener
,HomeFragment.OnFragmentInteractionListener{
    //이게 뭐하는거지 logt, logd
    private static final String TAG = "MainActivity";
    private ViewPager viewPager;
    private MenuItem prevMenuItem;
    private BottomNavigationViewEx bottomNavigationViewEx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Initializaing BottomNavigationView
        bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);

        //Initializing viewpager
        viewPager = (ViewPager)findViewById(R.id.Container);

        viewPager.addOnPageChangeListener(this);

        //setupViewPager
        setupViewpager(viewPager);

        Log.d(TAG, "onCreate: starting");

        setupBottomNavigationView();

    }

    /** BottomNavigationView setup common layout for all activity**/
    private void setupBottomNavigationView(){
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        //BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx)findViewById(R.id.bottomNavViewBar);
        BottomNavigationViewHelper.setupBottomNavigationView(bottomNavigationViewEx);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.ic_house:
                        viewPager.setCurrentItem(0);
                        return true;
                        //break;

                    case R.id.ic_search:
                        viewPager.setCurrentItem(1);
                        return true;
                        //break;

                    case R.id.ic_circle:
                        viewPager.setCurrentItem(2);
                        return true;
                        //break;

                    case R.id.ic_alert:
                        viewPager.setCurrentItem(3);
                        return true;
                        //break;

                    case R.id.ic_android:
                        viewPager.setCurrentItem(4);
                        return true;
                        //break;
                }

                return false;
            }
        });
    }



    private void setupViewpager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        LikesFragment likesFragment = new LikesFragment();
        ProfileFragment profileFragment = new ProfileFragment();
        SearchFragment searchFragment = new SearchFragment();
        ShareFragment shareFragment = new ShareFragment();
        HomeFragment homeFragment = new HomeFragment();

        adapter.addFragment(homeFragment);
        adapter.addFragment(searchFragment);
        adapter.addFragment(likesFragment);
        adapter.addFragment(profileFragment);
        adapter.addFragment(shareFragment);


        viewPager.setAdapter(adapter);

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (prevMenuItem != null){
            prevMenuItem.setChecked(false);
        }
        else{
            bottomNavigationViewEx.getMenu().getItem(0).setChecked(false);
        }
        Log.d("page", "onPageSelected: " +position);
        bottomNavigationViewEx.getMenu().getItem(position).setChecked(true);
        prevMenuItem = bottomNavigationViewEx.getMenu().getItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        private void addFragment(Fragment fragment){
            mFragmentList.add(fragment);
        }
    }


}
