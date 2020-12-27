package com.example.p7xiangmu.utils;

public interface INetCallBack<T> {
    public void OnSuccess(T t);
    public void OnFail(String error);
}
