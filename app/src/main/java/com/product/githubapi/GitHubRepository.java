package com.product.githubapi;

import com.google.gson.Gson;
import com.product.githubapi.constants.GitHubConstants;
import com.product.githubapi.http.GitHubHttpClient;
import com.product.githubapi.model.GitHubResponseModel;

import java.io.IOException;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GitHubRepository {
    /**
     * get data from server
     * @return response data
     */
    public Single<GitHubResponseModel> fetchServerData() {
        return Single.create(new SingleOnSubscribe<GitHubResponseModel>() {
            @Override
            public void subscribe(final SingleEmitter<GitHubResponseModel> emitter) throws Exception {
                final Call<ResponseBody> call = GitHubHttpClient.getRestClient(GitHubConstants.BASE_URL)
                        .create(GitHubApiResponse.class).getData();
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            String responseString = response.body().string();
                            GitHubResponseModel model = new Gson().fromJson(responseString, GitHubResponseModel.class);
                            emitter.onSuccess(model);
                        } catch (IOException io) {
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        emitter.onError(null);
                    }
                });
            }
        });

    }
}
