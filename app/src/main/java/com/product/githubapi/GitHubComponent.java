package com.product.githubapi;

import com.product.githubapi.viewmodel.GitHubViewModel;

import dagger.Component;

@Component(modules = GitHubModule.class)
public interface GitHubComponent {
    void inject(GitHubViewModel viewmodel);
}
