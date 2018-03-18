package com.achercasky.sample.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.achercasky.base.ui.LayoutStateView;
import com.achercasky.base.ui.utils.State;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final LayoutStateView stateView = findViewById(R.id.stateView);

//        mStatefulLayout.setStateView(STATE_CUSTOM, LayoutInflater.from(this).inflate(R.layout.custom_state, null));


        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                stateView.showOffline();
            }
        });
    }
}
