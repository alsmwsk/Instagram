package com.example.seowoo.instagram.Profile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.seowoo.instagram.R;

public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView option;
    private ItemClickListener itemClickListener;

    public MyViewHolder(View itemView) {
        super(itemView);
        option = (TextView)itemView.findViewById(R.id.list);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public void onClick(View v) {
        itemClickListener.onItemClick(v,getAdapterPosition());
    }

    public interface ItemClickListener {
        public void onItemClick(View view, int position);
    }
}
