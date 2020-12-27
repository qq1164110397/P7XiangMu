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

public class Item1Adapter extends DelegateAdapter.Adapter<Item1Adapter.MainViewHolder> {
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.ChannelBean> list;
    private Context context;

    public Item1Adapter(GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.ChannelBean> list, Context context) {
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
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item1_layout, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        MainViewHolder viewHolder = holder;
        Glide.with(context).load(list.get(position).getIcon_url()).into(viewHolder.img);
        viewHolder.txt.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;
        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
            txt = itemView.findViewById(R.id.txt);
        }
    }
}
