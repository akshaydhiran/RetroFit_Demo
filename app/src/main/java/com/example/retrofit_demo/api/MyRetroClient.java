package com.example.retrofit_demo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetroClient {

    private static Retrofit retrofit = null;
    private static Retrofit init(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.github.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public  static MyApi api = init().create(MyApi.class);
}
