package com.example.p7xiangmu.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.p7xiangmu.R;
import com.example.p7xiangmu.beans.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerAdapter extends DelegateAdapter.Adapter {

    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.BannerBean> list;
    private Context context;

    public BannerAdapter(LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.BannerBean> list, Context context) {
        this.linearLayoutHelper = linearLayoutHelper;
        this.list = list;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.banner_item_layout, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BannerViewHolder viewHolder = (BannerViewHolder) holder;
        viewHolder.banner.setImages(list).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataBean.BannerBean ban = (HomeBean.DataBean.BannerBean) path;
                Glide.with(context).load(ban.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {

        Banner banner;
        public BannerViewHolder(View view) {
            super(view);
            banner = view.findViewById(R.id.banner);
        }
    }
}
