package com.example.blackdandan.retrofitsourcecodeanylize;

import com.example.blackdandan.retrofitsourcecodeanylize.diyretrofit.DiyCall;
import com.example.blackdandan.retrofitsourcecodeanylize.diyretrofit.annotations.GET;

public interface ServiceTest {
    @GET("testPath")
    DiyCall<String> test();
}
