package com.product.githubapi.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.product.githubapi.databinding.ListItemBinding;
import com.product.githubapi.model.GitHubResponseModel;

import java.util.ArrayList;

/**
 * Adapter, to display list
 */
public class GitHubCommitsAdapter extends RecyclerView.Adapter<GitHubCommitsAdapter.GitHubCommitsViewHolder> {
    private Context mContext;
    private ArrayList<GitHubResponseModel> mList;
    private ListItemBinding binding;

    public GitHubCommitsAdapter(Context mContext, ArrayList<GitHubResponseModel> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public GitHubCommitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = ListItemBinding.inflate(inflater,parent,false);
        return new GitHubCommitsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GitHubCommitsViewHolder holder, int position) {
        holder.itemBinding.name.setText("Name: " + mList.get(position).getCommit().getAuthor().getName());
        holder.itemBinding.message.setText("Message: " + mList.get(position).getCommit().getMessage());
        holder.itemBinding.hash.setText("Hash: " + mList.get(position).getSha());
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class GitHubCommitsViewHolder extends RecyclerView.ViewHolder{
        private ListItemBinding itemBinding;

        public GitHubCommitsViewHolder(ListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    public  void updateList(ArrayList<GitHubResponseModel> updatedList){
        mList = updatedList;
        notifyDataSetChanged();
    }
}
