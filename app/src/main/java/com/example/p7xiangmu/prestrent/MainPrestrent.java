package com.example.p7xiangmu.prestrent;

import com.example.p7xiangmu.beans.HomeBean;
import com.example.p7xiangmu.contract.MainContract;
import com.example.p7xiangmu.fragment.HomeFragment;
import com.example.p7xiangmu.model.MainModel;
import com.example.p7xiangmu.utils.INetCallBack;
import com.example.p7xiangmu.utils.URLConstant;

public class MainPrestrent implements MainContract.IMainPrestrent {
    private final MainModel mainModel;
    private HomeFragment homeFragment;

    public MainPrestrent(HomeFragment homeFragment) {
        this.homeFragment = homeFragment;
        mainModel = new MainModel();
    }

    @Override
    public void getBanner() {
        mainModel.getHomeData(URLConstant.newlist, new INetCallBack<HomeBean>() {

            @Override
            public void OnSuccess(HomeBean homeBean) {
                homeFragment.OnSrucess(homeBean);
            }

            @Override
            public void OnFail(String error) {
                homeFragment.OnFail(error);
            }
        });
    }
}
