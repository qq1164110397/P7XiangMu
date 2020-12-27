package com.example.p7xiangmu.model;

import com.example.p7xiangmu.contract.MainContract;
import com.example.p7xiangmu.utils.INetCallBack;
import com.example.p7xiangmu.utils.RetrofitUtil;

public class MainModel implements MainContract.IMainModel {
    @Override
    public <T> void getHomeData(String url, INetCallBack<T> callBack) {
        RetrofitUtil.getInstance().get(url,callBack);
    }
}
