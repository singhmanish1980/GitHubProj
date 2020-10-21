package com.product.githubapi.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.product.githubapi.R;
import com.product.githubapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(getSupportFragmentManager().findFragmentByTag("fragment") == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new GitHubFragment(), "fragment")
                    .commit();
        }
    }
}
