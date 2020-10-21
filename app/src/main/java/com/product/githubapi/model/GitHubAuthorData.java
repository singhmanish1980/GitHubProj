package com.product.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubAuthorData {
    @SerializedName("name")
    private String name;

    public String getAuthor() {
        return name;
    }

    public void setAuthor(String name) {
        this.name = name;
    }
}
