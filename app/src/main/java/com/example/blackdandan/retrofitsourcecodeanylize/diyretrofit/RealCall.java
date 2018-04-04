package com.example.blackdandan.retrofitsourcecodeanylize.diyretrofit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RealCall<T> implements DiyCall {
    String url;
    String method;
    OkHttpClient okHttpClient;
    public RealCall(String url,String method){
        this.method = method;
        this.url = url;
        okHttpClient  =new  OkHttpClient.Builder().build();
    }
    @Override
    public T execute() throws Exception {
        Response response = okHttpClient.newCall(new Request.Builder().url("http://www.baidu.com/"+url).method(method,null).build()).execute();
        return (T) response.body().string();

    }
}
