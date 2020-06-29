package net.cuiwei.recyclerviewgroup.utility;

import com.ihsanbal.logging.Level;
import com.ihsanbal.logging.LoggingInterceptor;


import net.cuiwei.recyclerviewgroup.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.internal.platform.Platform;
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
        //OkHttpClient.Builder client=new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .client(getClient().build())
                .baseUrl("https://test.cuiwei.net/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient.Builder getClient(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(15, TimeUnit.SECONDS);
        //add log record
        if (BuildConfig.DEBUG) {
            //打印网络请求日志
            LoggingInterceptor httpLoggingInterceptor = new LoggingInterceptor.Builder()
                    .loggable(BuildConfig.DEBUG)
                    .setLevel(Level.BASIC)
                    .log(Platform.INFO)
                    .request("请求")
                    .response("响应")
                    .build();
            httpClientBuilder.addInterceptor(httpLoggingInterceptor);
        }
        return httpClientBuilder;
    }
}
