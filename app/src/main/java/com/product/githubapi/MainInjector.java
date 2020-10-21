package com.product.githubapi;

public enum MainInjector {
    INSTANCE;
    private static MainComponent component;

    public MainComponent getComponent(){
        if(component == null){
            component = DaggerMainComponent.builder().build();
        }
        return component;
    }
}
