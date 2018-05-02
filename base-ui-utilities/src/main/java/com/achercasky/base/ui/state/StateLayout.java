package com.achercasky.base.ui.state;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.FrameLayout;

import com.achercasky.base.ui.R;
import com.achercasky.base.ui.models.State;
import com.achercasky.base.ui.views.EmptyView;
import com.achercasky.base.ui.views.NoConnectionView;
import com.achercasky.base.ui.views.ProgressAnimView;

/**
 * Created by achercasky on 25/04/2018.
 */

public class StateLayout extends FrameLayout {

    private View contentView;

    private NoConnectionView noConnectionView;

    private EmptyView emptyView;

    private ProgressAnimView progressAnimView;

    private View currentShowingView;

    private Listener listener;

    public StateLayout(Context context) {
        this(context, null);
    }

    public StateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.ui_state_layout, this);
        initViews();
    }

    private void initViews() {
        noConnectionView = findViewById(R.id.ui_state_no_connection);

        emptyView = findViewById(R.id.ui_state_empty);

        progressAnimView = findViewById(R.id.ui_state_progress);

        currentShowingView = contentView;
    }

    public void setMainLayout(@NonNull final View view) {
        if (contentView == null) {
            contentView = view;
            currentShowingView = view;
        }
    }

    public void setViewSwitchAnimProvider(ViewAnimProvider viewSwitchAnimProvider) {
        if (viewSwitchAnimProvider != null) {
            this.showAnimation = viewSwitchAnimProvider.showAnimation();
            this.hideAnimation = viewSwitchAnimProvider.hideAnimation();
        }
    }

    public void setListener(final Listener listener) {
        this.listener = listener;
        noConnectionView.setCallback(listener);
    }

    public boolean isShouldPlayAnim() {
        return shouldPlayAnim;
    }

    public void setShouldPlayAnim(boolean shouldPlayAnim) {
        this.shouldPlayAnim = shouldPlayAnim;
    }

    private boolean shouldPlayAnim = true;
    private Animation hideAnimation;
    private Animation showAnimation;

    public Animation getShowAnimation() {
        return showAnimation;
    }

    public void setShowAnimation(Animation showAnimation) {
        this.showAnimation = showAnimation;
    }

    public Animation getHideAnimation() {
        return hideAnimation;
    }

    public void setHideAnimation(Animation hideAnimation) {
        this.hideAnimation = hideAnimation;
    }

    private void switchWithAnimation(final View toBeShown) {
        final View toBeHided = currentShowingView;
        if (toBeHided == toBeShown)
            return;
        if (shouldPlayAnim) {
            if (toBeHided != null) {
                if (hideAnimation != null) {
                    hideAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            toBeHided.setVisibility(GONE);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                    hideAnimation.setFillAfter(false);
                    toBeHided.startAnimation(hideAnimation);
                } else
                    toBeHided.setVisibility(GONE);
            }
            if (toBeShown != null) {
                if (toBeShown.getVisibility() != VISIBLE)
                    toBeShown.setVisibility(VISIBLE);
                currentShowingView = toBeShown;
                if (showAnimation != null) {
                    showAnimation.setFillAfter(false);
                    toBeShown.startAnimation(showAnimation);
                }
            }
        } else {
            if (toBeHided != null) {
                toBeHided.setVisibility(GONE);
            }
            if (toBeShown != null) {
                currentShowingView = toBeShown;
                toBeShown.setVisibility(VISIBLE);
            }
        }

    }

    private void showCurrentLayout(@NonNull final int state) {
        switch (state) {
            case State.CONTENT:
                emptyView.setVisibility(View.GONE);
                noConnectionView.setVisibility(View.GONE);
                progressAnimView.setVisibility(View.GONE);
                switchWithAnimation(contentView);
                break;
            case State.PROGRESS:
                currentShowingView.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
                noConnectionView.setVisibility(View.GONE);
                switchWithAnimation(progressAnimView);
                break;
            case State.OFFLINE:
                currentShowingView.setVisibility(View.GONE);
                emptyView.setVisibility(View.GONE);
                progressAnimView.setVisibility(View.GONE);
                switchWithAnimation(noConnectionView);
                break;
            case State.EMPTY:
                currentShowingView.setVisibility(View.GONE);
                noConnectionView.setVisibility(View.GONE);
                progressAnimView.setVisibility(View.GONE);
                switchWithAnimation(emptyView);
                break;
        }
    }

    public void showNoConnection() {
        showCurrentLayout(State.OFFLINE);
    }

    public void showEmptyView() {
        showCurrentLayout(State.EMPTY);
    }

    public void showProgressView() {
        showCurrentLayout(State.PROGRESS);
    }

    public void showContentView() {
        showCurrentLayout(State.CONTENT);
    }


    public void customProgressView(@NonNull final String title, @NonNull final int drawableImage) {
        progressAnimView.customizeProgress(title, drawableImage);
    }

    public interface Listener {
        void onRetry();
    }
}
