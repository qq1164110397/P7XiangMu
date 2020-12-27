package com.example.p7xiangmu.contract;

import com.example.p7xiangmu.beans.HomeBean;
import com.example.p7xiangmu.utils.INetCallBack;

public class MainContract {

    public interface IMainModel{
        <T>void getHomeData(String url, INetCallBack<T> callBack);
    }

    public interface IMainPrestrent{
        void getBanner();
    }

    public interface IMainView{
        void OnSrucess(HomeBean homeBean);
        void OnFail(String eror);
    }
}
