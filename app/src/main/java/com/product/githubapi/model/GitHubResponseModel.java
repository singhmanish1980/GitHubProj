package com.product.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubResponseModel {
    @SerializedName("commit")
    private GitHubAuthor commit;

    @SerializedName("message")
    private String message;

    @SerializedName("sha")
    private String sha;

    public GitHubAuthor getCommit() {
        return commit;
    }

    public void setCommit(GitHubAuthor commit) {
        this.commit = commit;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
