package com.product.githubapi;

import dagger.Module;
import dagger.Provides;

@Module
public class GitHubModule {

    @Provides
    MainRepository provideRepository(){
        return new MainRepository();
    }

}
