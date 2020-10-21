package com.product.githubapi.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.product.githubapi.GitHubInjector;
import com.product.githubapi.GitHubRepository;
import com.product.githubapi.model.GitHubData;
import com.product.githubapi.model.GitHubResponseModel;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@Singleton
public class GitHubViewModel extends ViewModel {
    @Inject
    GitHubRepository repository;

    GitHubResponseModel serverData = null;
    public MutableLiveData<ArrayList<GitHubData>> data = new MutableLiveData<>();

    public GitHubViewModel() {
        GitHubInjector.INSTANCE.getComponent().inject(this);
    }

    public MutableLiveData<ArrayList<GitHubData>> getGitHubList() {
        return data;
    }

    /**
     * get data from git hub api
     */
    public void fetchDataFromServer() {

        // Simple Observable
        if (serverData == null) {
            repository.fetchServerData().observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new SingleObserver<GitHubResponseModel>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onSuccess(GitHubResponseModel mainResponseModels) {
                            serverData = mainResponseModels;
                            // todo data.setValue();
                        }

                        @Override
                        public void onError(Throwable e) {
                            // todo
                        }
                    });
        } else {
            // todo data.setValue();
        }
    }
}
