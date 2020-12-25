package com.example.p7xiangmu.net;

public interface INetCallBack<T> {
    void OnScruess(T t);

    void OnFail(String error);
}
