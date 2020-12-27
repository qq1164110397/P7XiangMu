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

public class Item6Adapter extends DelegateAdapter.Adapter {

    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> list;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.CategoryListBean> listtxt;

    public Item6Adapter(ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> list, Context context, GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.CategoryListBean> listtxt) {
        this.list = list;
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.listtxt = listtxt;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1){
            View view1 = LayoutInflater.from(context).inflate(R.layout.item6_img_layout, parent, false);
            return new Volder1(view1);
        }else if (viewType == 2){
            View view2 = LayoutInflater.from(context).inflate(R.layout.item6_txt_layout, parent, false);
            return new Volder2(view2);
        }else {
            View view3 = LayoutInflater.from(context).inflate(R.layout.item6_price_layout, parent, false);
            return new Volder3(view3);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == 1){
            Volder1 volder1 = (Volder1) holder;
            volder1.txt.setText(listtxt.get(position).getName());
        }else if (getItemViewType(position) == 2){
            Volder2 volder2 = (Volder2) holder;
            volder2.txt.setText(listtxt.get(position).getName());
        }else {
            Volder3 volder3 = (Volder3) holder;
            Glide.with(context).load(list.get(position).getList_pic_url()).into(volder3.img);
            volder3.txt.setText(list.get(position).getName());
            volder3.price.setText("￥"+list.get(position).getRetail_price());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%7 == 0){
            return 1;
        }else if (position == 0){
            return 2;
        }else {
            return 3;
        }
    }

    private class Volder1 extends RecyclerView.ViewHolder {
        TextView txt;
        public Volder1(View view1) {
            super(view1);
            txt = view1.findViewById(R.id.txt);
        }
    }

    private class Volder2 extends RecyclerView.ViewHolder {
        TextView txt;
        public Volder2(View view2) {
            super(view2);
            txt = view2.findViewById(R.id.txt);
        }
    }

    private class Volder3 extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        TextView price;
        public Volder3(View view3) {
            super(view3);
            img = view3.findViewById(R.id.img);
            txt = view3.findViewById(R.id.txt);
            price = view3.findViewById(R.id.price);
        }
    }
}
