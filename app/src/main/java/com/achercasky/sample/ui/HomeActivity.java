package com.achercasky.sample.ui;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.achercasky.base.ui.state.StateLayout;
import com.achercasky.base.ui.test.StateLayoutView;
import com.achercasky.sample.ui.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    private StateLayoutView stateLayoutView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        stateLayoutView = findViewById(R.id.stateView);

        FrameLayout frameLayout = findViewById(R.id.content_frame);

        stateLayoutView.setContentLayout(frameLayout);

        Fragment newFragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

// Replace whatever is in the fragment_container view with this fragment,
// and add the transaction to the back stack if needed
        transaction.replace(R.id.content_frame, newFragment);
        transaction.addToBackStack(null);

// Commit the transaction
        transaction.commit();

//        final LayoutStateView stateView = findViewById(R.id.stateView);

//        mStatefulLayout.setStateView(STATE_CUSTOM, LayoutInflater.from(this).inflate(R.layout.custom_state, null));


        ((Button) findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                stateLayoutView.showNetworkErrorRefreshLayout();
            }
        });
    }
}
