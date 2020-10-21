package com.product.githubapi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GitHubApiResponse {
    @GET("/repos/singhmanish1980/GitHubProj/commits")
    Call<ResponseBody> getData();
}
