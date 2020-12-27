package com.example.p7xiangmu.utils;

import java.util.HashMap;

public interface INetWorkInterFace {

    public <T> void get(String url,INetCallBack<T> callBack);

    public <T> void post(String url,INetCallBack<T> callBack);

    public <T> void post(String url, HashMap<String,String> map,INetCallBack<T> callBack);
}
