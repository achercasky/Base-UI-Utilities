package com.achercasky.sample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.achercasky.base.ui.state.StateLayout;
import com.achercasky.sample.ui.R;

/**
 * Created by achercasky on 21/03/2018.
 */

public class HomeFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void onRetry() {
        Toast.makeText(getActivity(), "It works!", Toast.LENGTH_LONG).show();
    }

    @Override
    public StateLayout.Listener getStates() {
        return this;
    }
}
