package com.achercasky.sample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.achercasky.base.ui.state.StateLayout;
import com.achercasky.sample.ui.SampleStateLayoutActivity;

/**
 * Created by achercasky on 01/05/2018.
 */

public abstract class BaseFragment extends Fragment implements StateLayout.Listener{

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((SampleStateLayoutActivity) getActivity()).setListenerStates(getStates());
    }

    @Override
    public void showEmptyLayout() {

    }

    @Override
    public void showMainLayout() {

    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showRetryLayout() {
        Toast.makeText(getActivity(), "It works!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressLayout() {

    }

    public abstract StateLayout.Listener getStates();
}
