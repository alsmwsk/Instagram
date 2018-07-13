package com.example.seowoo.instagram.Profile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.seowoo.instagram.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    public TextView option;
    public LinearLayout parent;

    public MyViewHolder(View itemView) {
        super(itemView);
        option = itemView.findViewById(R.id.list);
        parent = itemView.findViewById(R.id.parent);
    }



}
