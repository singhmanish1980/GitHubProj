package com.product.githubapi.model;

import com.google.gson.annotations.SerializedName;

public class GitHubResponseModel {
    @SerializedName("commit")
    private GitHubCommit commit;

    @SerializedName("sha")
    private String sha;

    public GitHubCommit getCommit() {
        return commit;
    }

    public void setCommit(GitHubCommit commit) {
        this.commit = commit;
    }

    public String getSha() {
        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }
}
