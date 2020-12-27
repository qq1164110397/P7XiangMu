package com.example.p7xiangmu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7xiangmu.R;
import com.example.p7xiangmu.beans.HomeBean;

import java.util.ArrayList;

public class Item5Adapter extends DelegateAdapter.Adapter {

    private ArrayList<HomeBean.DataBean.TopicListBean> list;
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;

    public Item5Adapter(ArrayList<HomeBean.DataBean.TopicListBean> list, Context context, LinearLayoutHelper linearLayoutHelper) {
        this.list = list;
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item5, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        viewHolder.rlv.setLayoutManager(linearLayoutManager);
        Item5_xiao_Adapter fristTopPicZeroAdapter = new Item5_xiao_Adapter(context,list);
        viewHolder.rlv.setAdapter(fristTopPicZeroAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        RecyclerView rlv;
        public ViewHolder(View view) {
            super(view);
           rlv = view.findViewById(R.id.rlv);
        }
    }
}
