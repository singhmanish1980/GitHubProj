package com.product.githubapi;

public enum GitHubInjector {
    INSTANCE;
    private static GitHubComponent component;

    public GitHubComponent getComponent(){
        if(component == null){
            component = DaggerMainComponent.builder().build();
        }
        return component;
    }
}
