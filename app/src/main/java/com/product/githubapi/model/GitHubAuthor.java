package com.product.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubAuthor {
    @SerializedName("author")
    private GitHubAuthorData author;

    public GitHubAuthorData getAuthor() {
        return author;
    }

    public void setAuthor(GitHubAuthorData author) {
        this.author = author;
    }
}
