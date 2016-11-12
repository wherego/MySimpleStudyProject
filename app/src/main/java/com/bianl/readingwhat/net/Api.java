package com.bianl.readingwhat.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import okio.BufferedSink;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class Api {
    public static request request;

    public static request getInstance(){
        if(request ==null){
            //HttpLoggingInterceptor是OkHttp提供的一个用于记录网络请求的拦截器，
            //setLevel(HttpLoggingInterceptor.Level.BODY)意味着记录请求/响应行+头+体
            HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.d("OkHttp",message);
                }
            });
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient okHttpClient=new OkHttpClient.Builder().
                    addNetworkInterceptor(interceptor).
                    readTimeout(60, TimeUnit.SECONDS).
                    connectTimeout(60,TimeUnit.SECONDS).
                    build();

            GsonBuilder builder=new GsonBuilder();
            builder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
            Gson gson=builder.create();

            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(com.bianl.readingwhat.net.request.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            request =retrofit.create(request.class);
        }
        return request;
    }
}
