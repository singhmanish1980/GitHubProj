package com.product.githubapi.view;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.product.githubapi.databinding.MainFragmentBinding;
import com.product.githubapi.model.GitHubResponseModel;
import com.product.githubapi.viewmodel.GitHubViewModel;

import java.util.ArrayList;

public class GitHubFragment extends Fragment {
    private static final String TAG = "MainFragment";
    private MainFragmentBinding binding;

    private GitHubViewModel viewModel;
    private ProgressDialog loading;
    private ArrayList<GitHubResponseModel> dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(viewModel == null) {
            viewModel = new ViewModelProvider(this).get(GitHubViewModel.class);
        }

        if(loading == null) {
            loading = new ProgressDialog(getContext());
            loading.setCancelable(true);
            loading.setMessage("Loading..");
            loading.show();
        }
        viewModel.fetchDataFromServer();
        observeData();
    }

    @VisibleForTesting
    public GitHubViewModel getViewModel() {
        return viewModel;
    }


    private void observeData() {
        viewModel.getGitHubList().observe(getViewLifecycleOwner(), new Observer<ArrayList<GitHubResponseModel>>() {
            @Override
            public void onChanged(ArrayList<GitHubResponseModel> data) {
                dataList = data;
                loading.dismiss();
            }
        });
    }
}
