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

/**
 * Created by achercasky on 30/04/2018.
 */

public class EmptyView extends FrameLayout {

    private Callback callback;

    private LinearLayout container;

    public EmptyView(@NonNull final Context context) {
        super(context);
        initViews();
    }

    public EmptyView(@NonNull final Context context, @NonNull final Callback callback) {
        super(context);

        this.callback = callback;

        initViews();
    }

    public EmptyView(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }

    public void setCallback(final Callback callback) {
        this.callback = callback;
    }

    private void initViews() {
        inflate(getContext(), R.layout.ui_empty, this);

        container = findViewById(R.id.container_no_internet);

        final Button retry = findViewById(R.id.ui_no_connection_btn);

        if(retry != null) {
            retry.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(final View v) {
                    callback.onRetry();
                }
            });
        }
    }

    public void display() {
        container.setVisibility(View.VISIBLE);
    }

    public void hide() {
        container.setVisibility(View.GONE);
    }

    public interface Callback {
        void onRetry();
    }
}
