package com.example.p7xiangmu.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p7xiangmu.R;
import com.example.p7xiangmu.ShouActicty;
import com.example.p7xiangmu.beans.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView rlv;
    private Banner banner;
    private ImageView img;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment, null);
        rlv = view.findViewById(R.id.rlv);
        banner = view.findViewById(R.id.banner);
        img = view.findViewById(R.id.img);
        initView();
        return view;
    }

    private void initView() {
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShouActicty.class));
            }
        });

        bannerlist = new ArrayList<>();
        new ArrayList<>();
    }
}
