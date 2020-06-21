package com.example.work.myapplication.utility;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Http {
    private static Http manager;
    public static Retrofit retrofit;

    public static synchronized Http getManager() {
        if (manager == null) {
            manager = new Http();
        }
        return manager;
    }
    public Retrofit getRetrofit() {
        if (retrofit == null) {
            return genericRetrofit();
        }
        return retrofit;
    }
    public Retrofit genericRetrofit() {
        /*
         **打印retrofit信息部分
         */
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                //打印retrofit日志
                System.out.println("retrofit: "+message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //OkHttpClient.Builder client=new OkHttpClient.Builder();
        OkHttpClient client = new OkHttpClient.Builder()//okhttp设置部分，此处还可再设置网络参数
                .addInterceptor(loggingInterceptor)
                .build();
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl("https://test.cuiwei.net/")
                .build();
    }
}
