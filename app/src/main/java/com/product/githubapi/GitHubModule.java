package com.product.githubapi;

import dagger.Module;
import dagger.Provides;

@Module
public class GitHubModule {

    @Provides
    GitHubRepository provideRepository(){
        return new GitHubRepository();
    }

}
