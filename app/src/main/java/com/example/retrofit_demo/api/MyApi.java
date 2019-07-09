package com.example.retrofit_demo.api;

import com.example.retrofit_demo.model.GithubFollowersPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApi {

    @GET("users/{user}/followers")
    Call <List<GithubFollowersPojo>> getFollowers(@Path("user") String user);
}
