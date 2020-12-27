package com.example.p7xiangmu.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.p7xiangmu.R;
import com.example.p7xiangmu.beans.HomeBean;

import java.util.ArrayList;

public class Item5_xiao_Adapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> list;

    public Item5_xiao_Adapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item5_xiao, parent, false);
        return new ViewHolder0(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder0 viewHolder0 = (ViewHolder0) holder;
        Glide.with(context).load(list.get(position).getItem_pic_url()).into(viewHolder0.img);
        viewHolder0.txt1.setText(list.get(position).getTitle());
//        viewHolder0.txt2.setText((double)list.get(position).getPrice_info());
        viewHolder0.txt3.setText(list.get(position).getSubtitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    private class ViewHolder0 extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt1;
        TextView txt2;
        TextView txt3;
        public ViewHolder0(View view) {
            super(view);
            img = view.findViewById(R.id.img);
            txt1 = view.findViewById(R.id.txt_name);
            txt2 = view.findViewById(R.id.txt_price);
            txt3 = view.findViewById(R.id.txt_jie);
        }
    }
}

