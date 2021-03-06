package com.example.p7xiangmu.fragment;

import android.content.Intent;
import android.graphics.Color;
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
import com.example.p7xiangmu.adapters.FristCateAdapter;
import com.example.p7xiangmu.adapters.FristCateHeaderAdapter;
import com.example.p7xiangmu.adapters.Item1Adapter;
import com.example.p7xiangmu.adapters.Item2Adapter;
import com.example.p7xiangmu.adapters.Item3Adapter;
import com.example.p7xiangmu.adapters.Item4Adapter;
import com.example.p7xiangmu.adapters.Item5Adapter;
import com.example.p7xiangmu.adapters.Item6Adapter;
import com.example.p7xiangmu.beans.HomeBean;
import com.example.p7xiangmu.contract.MainContract;
import com.example.p7xiangmu.prestrent.MainPrestrent;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

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
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsList;
    private Item4Adapter item4Adapter;
    private Item5Adapter item5Adapter;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicList;
    private Item6Adapter item6Adapter;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodlist;
    private ArrayList<HomeBean.DataBean.CategoryListBean> catelist;
    private ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans;
    private FristCateAdapter fristCateAdapter;
    private FristCateHeaderAdapter fristCateHeaderAdapter1;
    private LinearLayoutHelper linearLayoutHelper1;

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
        helper.setAspectRatio(3);
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
        initTWO();
        initSHREE();
        initFOUR();

        bannerAdapter = new BannerAdapter(linearLayoutHelper,bannerlist,getActivity());
        item1Adapter = new Item1Adapter(helper,channellist,getActivity());
        item2Adapter = new Item2Adapter(helper2,brandlist,getActivity());

        initAdapter();
    }

    private void initTWO() {
        GridLayoutHelper helper4 = new GridLayoutHelper(3);
        helper4.setItemCount(4);// 设置布局里Item个数
        helper4.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
//        helper.setPadding(10,10,10,10);
//        helper.setMargin(10,10,10,10);
        helper4.setWeights(new float[]{100,100});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        helper4.setAutoExpand(false);//是否自动填充空白区域
        helper4.setSpanCount(1);// 设置每行多少个网格

        item4Adapter = new Item4Adapter(helper4,hotGoodsList,getActivity());

    }

    private void initONE() {
        GridLayoutHelper helper3 = new GridLayoutHelper(3);
        helper3.setItemCount(4);// 设置布局里Item个数
        helper3.setAspectRatio(2);// 设置设置布局内每行布局的宽与高的比
        helper.setPadding(20,20,20,20);
        helper.setMargin(10,10,10,10);
        helper3.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        helper3.setAutoExpand(false);//是否自动填充空白区域
        helper3.setSpanCount(2);// 设置每行多少个网格

        item3Adapter = new Item3Adapter(helper3, newgoodlist,getActivity());
    }

    private void initSHREE() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper.setPadding(10,10,10,10);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        linearLayoutHelper.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        linearLayoutHelper.setAspectRatio(1);// 设置设置布局内每行布局的宽与高的比

        // linearLayoutHelper特有属性
        linearLayoutHelper.setDividerHeight(1); // 设置每行Item的距离

        item5Adapter = new Item5Adapter(topicList,getActivity(),linearLayoutHelper);
    }

    private void initFOUR() {



    }

    private void initView() {

        MainPrestrent mainPrestrent = new MainPrestrent(this);
        mainPrestrent.getBanner();

        bannerlist = new ArrayList<>();
        channellist = new ArrayList<>();
        brandlist = new ArrayList<>();
        newgoodlist = new ArrayList<>();
        hotGoodsList = new ArrayList<>();
        topicList = new ArrayList<>();
        goodlist = new ArrayList<>();
        catelist = new ArrayList<>();
    }

    private void initAdapter() {
        adapter = new DelegateAdapter(virtualLayoutManager);
        adapter.addAdapter(bannerAdapter);
        adapter.addAdapter(item1Adapter);
        adapter.addAdapter(item2Adapter);
        adapter.addAdapter(item3Adapter);
        adapter.addAdapter(item4Adapter);
        adapter.addAdapter(item5Adapter);
        rlv.setLayoutManager(virtualLayoutManager);
        rlv.setAdapter(adapter);
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

        hotGoodsList.addAll(homeBean.getData().getHotGoodsList());
        item4Adapter.notifyDataSetChanged();

        topicList.addAll(homeBean.getData().getTopicList());
        item5Adapter.notifyDataSetChanged();

        categoryListBeans = new ArrayList<>();

        /**
         设置线性布局
         */
        linearLayoutHelper1 = new LinearLayoutHelper();
        // 创建对应的LayoutHelper对象

        // 所有布局的公共属性（属性会在下面详细说明）
        linearLayoutHelper1.setItemCount(1);// 设置布局里Item个数
        linearLayoutHelper1.setPadding(0,0,0,0);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        linearLayoutHelper.setMargin(10,10,10,10);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
//        linearLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色


        // linearLayoutHelper特有属性
        linearLayoutHelper1.setDividerHeight(1); // 设置每行Item的距离
        categoryListBeans = new ArrayList<>();



        List<HomeBean.DataBean.CategoryListBean> categoryList = homeBean.getData().getCategoryList();
        categoryListBeans.clear();
        categoryListBeans.addAll(categoryList);
        for (int i = 0; i < categoryListBeans.size(); i++) {
            String name = categoryListBeans.get(i).getName();
            fristCateHeaderAdapter1 = new FristCateHeaderAdapter(getActivity(), name, linearLayoutHelper1);
            fristCateHeaderAdapter1.notifyDataSetChanged();


            GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
            // 在构造函数设置每行的网格个数

            // 公共属性
            gridLayoutHelper.setItemCount(7);// 设置布局里Item个数
//        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离

//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

            // gridLayoutHelper特有属性（下面会详细说明）
            gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
            gridLayoutHelper.setVGap(5);// 控制子元素之间的垂直间距
            gridLayoutHelper.setHGap(5);// 控制子元素之间的水平间距
            gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
            gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
            gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色


            List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBeans.get(i).getGoodsList();
            fristCateAdapter = new FristCateAdapter(getActivity(), (ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean>) goodsList, gridLayoutHelper);
            adapter.addAdapter(fristCateHeaderAdapter1);
            adapter.addAdapter(fristCateAdapter);
        }

        List<HomeBean.DataBean.CategoryListBean> categoryLis = homeBean.getData().getCategoryList();
        categoryListBeans.clear();
        categoryListBeans.addAll(categoryLis);
        for (int i = 0; i < categoryListBeans.size(); i++) {
            String name = categoryListBeans.get(i).getName();
            fristCateHeaderAdapter1 = new FristCateHeaderAdapter(getActivity(), name, linearLayoutHelper1);
            fristCateHeaderAdapter1.notifyDataSetChanged();


            GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
            // 在构造函数设置每行的网格个数

            // 公共属性
            gridLayoutHelper.setItemCount(7);// 设置布局里Item个数
//        gridLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
//        gridLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离

//        gridLayoutHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

            // gridLayoutHelper特有属性（下面会详细说明）
            gridLayoutHelper.setWeights(new float[]{50,50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
            gridLayoutHelper.setVGap(5);// 控制子元素之间的垂直间距
            gridLayoutHelper.setHGap(5);// 控制子元素之间的水平间距
            gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
            gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
            gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色



            List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBeans.get(i).getGoodsList();
            fristCateAdapter = new FristCateAdapter(getActivity(),(ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean>) goodsList,gridLayoutHelper);
            adapter.addAdapter(fristCateHeaderAdapter1);
            adapter.addAdapter(fristCateAdapter);
        }
    }

    @Override
    public void OnFail(String eror) {

    }
}
