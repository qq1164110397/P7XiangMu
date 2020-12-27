package com.example.p7xiangmu.fragment;

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

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.p7xiangmu.R;
import com.example.p7xiangmu.ShouActicty;
import com.example.p7xiangmu.adapters.BannerAdapter;
import com.example.p7xiangmu.adapters.Item1Adapter;
import com.example.p7xiangmu.adapters.Item2Adapter;
import com.example.p7xiangmu.adapters.Item3Adapter;
import com.example.p7xiangmu.beans.HomeBean;
import com.example.p7xiangmu.contract.MainContract;
import com.example.p7xiangmu.prestrent.MainPrestrent;
import com.youth.banner.Banner;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements MainContract.IMainView{

    private RecyclerView rlv;
    private Banner banner;
    private ImageView img;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandlist;
    private MainPrestrent mainPrestrent;
    private GridLayoutHelper helper;
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;
    private DelegateAdapter adapter;
    private Item1Adapter item1Adapter;
    private BannerAdapter bannerAdapter;
    private VirtualLayoutManager virtualLayoutManager;
    private Item2Adapter item2Adapter;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newgoodlist;
    private Item3Adapter item3Adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment, null);
        rlv = view.findViewById(R.id.rlv);
        banner = view.findViewById(R.id.banner);
        img = view.findViewById(R.id.img);
        initView();
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ShouActicty.class));
            }
        });
        initData();

        return view;
    }

    private void initData() {
        //创建RecyclerView & VirtualLayoutManager 对象并进行绑定
        virtualLayoutManager = new VirtualLayoutManager(getActivity());
        rlv.setLayoutManager(virtualLayoutManager);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();

        //设置回收复用池大小
        RecyclerView.RecycledViewPool pool = new RecyclerView.RecycledViewPool();
        rlv.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0,10);
        linearLayoutHelper.setItemCount(1);


        helper = new GridLayoutHelper(3);
        helper.setItemCount(1);
        helper.setPadding(10,10,10,10);
        helper.setMargin(10,10,10,10);
        helper.setAspectRatio(2);
        helper.setWeights(new float[]{20,20,20,20});
        helper.setVGap(20);
        helper.setHGap(20);
        helper.setAutoExpand(false);
        helper.setSpanCount(5);

        GridLayoutHelper helper2 = new GridLayoutHelper(3);
        helper2.setItemCount(4);// 设置布局里Item个数
        helper2.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        helper2.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        helper2.setAutoExpand(false);//是否自动填充空白区域
        helper2.setSpanCount(2);// 设置每行多少个网格

        initONE();

        bannerAdapter = new BannerAdapter(linearLayoutHelper,bannerlist,getActivity());
        item1Adapter = new Item1Adapter(helper,channellist,getActivity());
        item2Adapter = new Item2Adapter(helper2,brandlist,getActivity());


        adapter = new DelegateAdapter(virtualLayoutManager);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(item1Adapter);
        adapter.addAdapter(item2Adapter);
        rlv.setLayoutManager(virtualLayoutManager);
        rlv.setAdapter(adapter);
    }

    private void initONE() {
        GridLayoutHelper helper3 = new GridLayoutHelper(3);
        helper3.setItemCount(4);// 设置布局里Item个数
        helper3.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比
        helper3.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        helper3.setAutoExpand(false);//是否自动填充空白区域
        helper3.setSpanCount(2);// 设置每行多少个网格

        item3Adapter = new Item3Adapter(helper3, newgoodlist,getActivity());
    }

    private void initView() {

        MainPrestrent mainPrestrent = new MainPrestrent(this);
        mainPrestrent.getBanner();

        bannerlist = new ArrayList<>();
        channellist = new ArrayList<>();
        brandlist = new ArrayList<>();
        newgoodlist = new ArrayList<>();
    }

    @Override
    public void OnSrucess(HomeBean homeBean) {
        bannerlist.addAll(homeBean.getData().getBanner());
        bannerAdapter.notifyDataSetChanged();

        channellist.addAll(homeBean.getData().getChannel());
        item1Adapter.notifyDataSetChanged();

        brandlist.addAll(homeBean.getData().getBrandList());
        item2Adapter.notifyDataSetChanged();

        newgoodlist.addAll(homeBean.getData().getNewGoodsList());
        item3Adapter.notifyDataSetChanged();

    }

    @Override
    public void OnFail(String eror) {

    }
}
