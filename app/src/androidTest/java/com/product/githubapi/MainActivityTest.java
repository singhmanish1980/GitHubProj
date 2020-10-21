package com.product.githubapi;

import android.os.Handler;
import android.os.Looper;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.product.githubapi.view.GitHubFragment;
import com.product.githubapi.view.MainActivity;
import com.product.githubapi.viewmodel.GitHubViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    GitHubFragment fragment;
    GitHubViewModel viewModel;

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class,
            true, true);

    @Before
    public void initCall() {
        fragment = (GitHubFragment) activityRule.getActivity().getSupportFragmentManager().findFragmentByTag("fragment");
        viewModel = fragment.getViewModel();
    }

    @Test
    public void serverCall() throws InterruptedException {
        assertNotNull(fragment);
        assertNotNull(viewModel);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                assertNotNull(viewModel.getGitHubListData());
            }
        }, 5000);
    }
}
