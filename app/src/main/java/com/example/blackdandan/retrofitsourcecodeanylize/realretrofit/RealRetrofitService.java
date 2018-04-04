package com.example.blackdandan.retrofitsourcecodeanylize.realretrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RealRetrofitService {
    @GET("s?ie=utf-8&f=3&rsv_bp=0&rsv_idx=1&tn=baidu&wd=115&rsv_pq=846eb66f00041366&rsv_t=e7a6vW3UM%2FpA4HvORp7QckzXiUnrvY%2BeDdw4LLGSbzF9yaodqxeVk9i9jbQ&rqlang=cn&rsv_enter=1&rsv_sug3=3&rsv_sug1=2&rsv_sug7=100&rsv_sug2=1&prefixsug=11&rsp=0&inputT=1118&rsv_sug4=1170")
    Call<ResponseBody> realTestService();
}
