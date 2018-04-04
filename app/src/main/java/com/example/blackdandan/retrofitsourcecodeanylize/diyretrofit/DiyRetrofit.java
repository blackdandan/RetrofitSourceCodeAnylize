package com.example.blackdandan.retrofitsourcecodeanylize.diyretrofit;

import com.example.blackdandan.retrofitsourcecodeanylize.ServiceTest;
import com.example.blackdandan.retrofitsourcecodeanylize.diyretrofit.annotations.GET;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.http.HttpMethod;
import retrofit2.Retrofit;

public class DiyRetrofit {
    /**
     * 首先学习一下动态代理,就是用Java的Proxy在运行时为class生成一个代理类
     * 当class被执行的时候运行代理类里面的invoke方法
     * 这样做就可以做到只在外面定义方法,然后框架内部来使用方法的参数,注解来
     * 对方法进行封装打包来调用
     * @param service
     * @param <T>
     * @return
     */
    public <T> T create(final Class<T> service){
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("do====invoke.method:"+method.getName());
                System.out.println("do====invoke.args:"+args.length);

                //最后是要返回一个DIYCall,那么我们怎么生成这个DIYCall呢,
                //Retrofit采用的方法是根据Service的参数和注解来产生,Okhttp的Call
                //然后其他的功能后面再+
                return getDIYCall(method);
            }
        });

    }
    private DiyCall<?> getDIYCall(Method method){
        String httpMethod = null;
        String path = null;


        Annotation[] annotation = method.getAnnotations();//获取注解
        System.out.println("do====annotations:length:"+annotation.length);
        System.out.println("do====annotations:toString:"+annotation.toString());
        for (int i = 0;i<annotation.length;i++){
            if (annotation[i] instanceof GET){
                System.out.println("do====GET.Value:"+((GET)annotation[i]).value());
                System.out.println("do====GET.Value:"+((GET)annotation[i]).test());
                httpMethod = "GET";
                path = ((GET)annotation[i]).value();

            }
        }
        return new RealCall(path,httpMethod);
    }
}
