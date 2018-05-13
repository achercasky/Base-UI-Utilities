package com.achercasky.base.ui.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.achercasky.base.ui.R;
import com.achercasky.base.ui.state.StateLayout;

/**
 * Created by achercasky on 30/04/2018.
 */

public class NoConnectionView extends FrameLayout {

//    private Callback callback;

    private LinearLayout container;

    private StateLayout.Listener listener;

    public NoConnectionView(@NonNull final Context context) {
        super(context);
        initViews();
    }

    public NoConnectionView(@NonNull final Context context, @NonNull final StateLayout.Listener listener) {
        super(context);

        this.listener = listener;

        initViews();
    }

    public NoConnectionView(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public void setCallback(final StateLayout.Listener listener) {
        this.listener = listener;
    }

    private void initViews() {
        inflate(getContext(), R.layout.ui_no_connection, this);

        container = findViewById(R.id.container_no_internet);

        final Button retry = findViewById(R.id.ui_no_connection_btn);
        retry.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                listener.showRetryLayout();
            }
        });
    }

    public void display() {
        container.setVisibility(View.VISIBLE);
    }

    public void hide() {
        container.setVisibility(View.GONE);
    }

//    public interface Callback {
//        void onRetry();
//    }
}
