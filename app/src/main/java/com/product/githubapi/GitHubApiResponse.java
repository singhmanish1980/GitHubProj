package com.product.githubapi;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubApiResponse {
    @GET
    Call<ResponseBody> getData();
}
