package com.product.githubapi.http;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GitHubHttpClient {
    private static Retrofit retrofitClient = null;

    /**
     * Method to get the Retrofit rest client object to make the HTTPs Calls
     */
    public static Retrofit getRestClient(String url) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        OkHttpClient okHttpClient = httpClient.build();

        if (retrofitClient == null) {
            retrofitClient = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }

        return retrofitClient;
    }
}
