package com.example.seowoo.instagram.Profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.seowoo.instagram.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {


    //항목 구성 데이터
    private List<ItemForm> list;
    //Context 토스트나 인텐트를 쓸려면 필요하다..
    private Context mContext;
    // RecyclerView
    private RecyclerView mRecyclerView;
    // LinearLayout
    private LinearLayout mLinearLayout;


    //항목을 구성하기 위한 layout xml 파일 inflate
    //이곳의 리턴값은 inflate된 view의 계층 구조에서
    //view를 findViewyId할 ViewHolder 리턴
    public MyAdapter(Context context, List<ItemForm> list, RecyclerView mRecyclerView, LinearLayout mLinearLayout ) {
        mContext = context;
        this.list = list;
        this.mRecyclerView = mRecyclerView;
        this.mLinearLayout = mLinearLayout;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        view.setOnClickListener(new MyOnclickListener());
        return new MyViewHolder(view);
    }

    //각 항목을 구성하기 위해서 호출
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        ItemForm data = list.get(position); // 위치에 따라서 그에 맞는 데이터 얻어오기
        holder.option.setText(data.getId()); // 앞서 뷰홀더에 세팅해준 것을 각 위치에 할당

        // 아이템 클릭리스너
//        holder.parent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mContext, list.get(position).getId(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    //항목개수
    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(final View v) {
            int itemPosition = mRecyclerView.getChildLayoutPosition(v);
            String item = list.get(itemPosition).getId();
            Toast.makeText(mContext, item, Toast.LENGTH_LONG).show();
        }

    }

}
