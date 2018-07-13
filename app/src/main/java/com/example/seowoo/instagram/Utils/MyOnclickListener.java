package com.example.seowoo.instagram.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.seowoo.instagram.Profile.ItemForm;

import java.util.List;

/**
 * Created by seowoo on 2018-07-13.
 */

public class MyOnclickListener implements View.OnClickListener {

    Context mContext;
    RecyclerView mRecyclerView;
    List<ItemForm> list;

    public MyOnclickListener(Context mContext, RecyclerView mRecyclerView, List<ItemForm> list) {
        this.mContext = mContext;
        this.mRecyclerView = mRecyclerView;
        this.list = list;
    }

    @Override
    public void onClick(View view) {
       int itemPosition = mRecyclerView.getChildLayoutPosition(view);
       String item = list.get(itemPosition).getId();
       Toast.makeText(mContext, item, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onClick(Context mContext, final View v, RecyclerView mRecyclerView, List<ItemForm> list) {
//
//        int itemPosition = mRecyclerView.getChildLayoutPosition(v);
//        String item = list.get(itemPosition).getId();
//        Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();
//    }

}
