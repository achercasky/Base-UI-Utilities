package com.achercasky.sample.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.achercasky.base.ui.state.StateLayout;
import com.achercasky.sample.ui.SampleStateLayoutActivity;

/**
 * Created by achercasky on 01/05/2018.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((SampleStateLayoutActivity) getActivity()).setListenerStates(getStates());
    }

    public abstract StateLayout.Listener getStates();
}
