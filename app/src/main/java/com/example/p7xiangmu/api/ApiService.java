package com.example.p7xiangmu.api;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {
    String url = "https://cdwan.cn/";

    @GET("api/index")
    Observable<ResponseBody> getbanner();
}
