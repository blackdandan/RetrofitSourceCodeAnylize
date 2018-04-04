package com.example.blackdandan.retrofitsourcecodeanylize.retrofit;

import com.example.blackdandan.retrofitsourcecodeanylize.ServiceTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.internal.platform.Platform;

public class Retrofit {
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
                System.out.println("do====invoke.args:"+args);

                return method.invoke(new ServiceTest() {
                    @Override
                    public void test() {

                    }
                }, args);
            }
        });
    }
}
