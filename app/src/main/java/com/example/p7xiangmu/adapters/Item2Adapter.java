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

public class Item2Adapter extends DelegateAdapter.Adapter {

    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.BrandListBean> list;
    private Context context;

    public Item2Adapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.BrandListBean> list, Context context) {
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
        View view = LayoutInflater.from(context).inflate(R.layout.item2_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        Glide.with(context).load(list.get(position).getNew_pic_url()).into(viewHolder.img);
        viewHolder.name.setText(list.get(position).getName());
        viewHolder.name.setText(list.get(position).getFloor_price()+"元起");
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
            price = view.findViewById(R.id.txt2);
        }
    }
}
