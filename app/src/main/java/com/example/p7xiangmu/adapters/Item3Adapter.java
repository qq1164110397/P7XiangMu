package com.example.p7xiangmu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7xiangmu.R;
import com.example.p7xiangmu.beans.HomeBean;

import java.util.ArrayList;

public class Item3Adapter extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> list;
    private Context context;

    public Item3Adapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.NewGoodsListBean> list, Context context) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item3_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getList_pic_url()).into(viewHolder.img);
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.price.setText("￥"+list.get(position).getRetail_price());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public ViewHolder(View view) {
            super(view);
            img = view.findViewById(R.id.img);
            name = view.findViewById(R.id.txt);
            price = view.findViewById(R.id.pic);
        }
    }
}
