package com.product.githubapi.viewmodel;

import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.product.githubapi.GitHubInjector;
import com.product.githubapi.GitHubRepository;
import com.product.githubapi.model.GitHubResponseModel;

import java.util.ArrayList;
import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@Singleton
public class GitHubViewModel extends ViewModel {
    @Inject
    GitHubRepository repository;

    ArrayList<GitHubResponseModel> serverListData = null;
    public MutableLiveData<ArrayList<GitHubResponseModel>> serverLiveData = new MutableLiveData<>();

    final int PAGE_SIZE = 25;

    public GitHubViewModel() {
        GitHubInjector.INSTANCE.getComponent().inject(this);
    }

    public MutableLiveData<ArrayList<GitHubResponseModel>> getGitHubList() {
        return serverLiveData;
    }

    @VisibleForTesting
    public ArrayList<GitHubResponseModel> getGitHubListData() {
        return serverListData;
    }

    /**
     * get data from git hub api
     */
    public void fetchDataFromServer() {
        if(serverListData != null) {
            serverListData.clear();
        }
        // Simple Observable
        repository.fetchServerData().observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<GitHubResponseModel[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(GitHubResponseModel[] responseModels) {
                        setServerInitialData(responseModels);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // todo
                    }
                });
    }

    void setServerInitialData(GitHubResponseModel[] responseModel){
        if(responseModel.length > PAGE_SIZE) {
            serverListData = new ArrayList<>(Arrays.asList(responseModel).subList(0, PAGE_SIZE));
        } else {
            serverListData = new ArrayList<>(Arrays.asList(responseModel));
        }
        serverLiveData.postValue(serverListData);
    }
}
