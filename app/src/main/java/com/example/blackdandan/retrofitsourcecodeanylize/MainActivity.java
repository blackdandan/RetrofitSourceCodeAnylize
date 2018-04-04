package com.example.blackdandan.retrofitsourcecodeanylize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;

import com.example.blackdandan.retrofitsourcecodeanylize.diyretrofit.DiyCall;
import com.example.blackdandan.retrofitsourcecodeanylize.diyretrofit.DiyRetrofit;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DiyRetrofit diyRetrofit = new DiyRetrofit();
        ServiceTest serviceTest = diyRetrofit.create(ServiceTest.class);
        final DiyCall<String> call = serviceTest.test();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("do====result:"+call.execute());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();



    }
}
