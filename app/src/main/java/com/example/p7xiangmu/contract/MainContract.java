package com.example.p7xiangmu.contract;

import com.example.p7xiangmu.beans.HomeBean;
import com.example.p7xiangmu.net.INetCallBack;

public class MainContract {

    public interface IMainModel{
        <T>void getHomeData(String url, INetCallBack<T> callBack);
    }

    public interface IMainPrestrent{
        void OnScruess(HomeBean homeBean);

        void OnFail(String error);
    }

    public interface IMainView{
        void getData(HomeBean homeBean);
    }
}
