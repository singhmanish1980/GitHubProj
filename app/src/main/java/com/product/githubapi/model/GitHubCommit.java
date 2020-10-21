package com.product.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubCommit {
    @SerializedName("author")
    private GitHubAuthorData author;

    @SerializedName("message")
    private String message;

    public GitHubAuthorData getAuthor() {
        return author;
    }

    public void setAuthor(GitHubAuthorData author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
