package com.achercasky.base.ui.test;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IntDef;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.achercasky.base.ui.LayoutViewUtils;
import com.achercasky.base.ui.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


/**
 * Created by achercasky on 19/03/2018.
 */

public class StateLayoutView extends FrameLayout {

    private static final int REGULAR_LAYOUT = 0;
    private static final int PROGRESS_LAYOUT = 1;
    private static final int NETWORK_ERROR_LAYOUT = 2;
    private static final int RETRY_LAYOUT = 3;

    /* default */ View mContentLayout;
    private OnClickListener mErrorListener;

    @IntDef({ REGULAR_LAYOUT, PROGRESS_LAYOUT, NETWORK_ERROR_LAYOUT, RETRY_LAYOUT })
    @Retention(RetentionPolicy.SOURCE)
    private @interface ViewState {
    }

    @SuppressWarnings("PMD.FieldDeclarationsShouldBeAtStartOfClass")
    @ViewState
    private int currentLayoutState = REGULAR_LAYOUT;

    /**
     * Constructor
     * @param context The context
     * @param attrs The attributes
     */
    public StateLayoutView(final Context context, final AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Constructor
     * @param context the context
     * @param attrs The attributes
     * @param defStyleAttr The styles
     */
    public StateLayoutView(final Context context, final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * Get the current layout state
     * @return the state
     */
    @ViewState
    public int getCurrentLayoutState() {
        return currentLayoutState;
    }

    private void init() {
//        final LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(LayoutViewUtils.getInstance().getMainLayout(), this, true);
//        setVisibility(GONE);
    }

    /**
     * Set the content layout
     * @param contentLayout The content layout
     */
    public void setContentLayout(final View contentLayout) {
        this.mContentLayout = contentLayout;
        setVisibility(GONE);
    }

    @SuppressWarnings("checkstyle:indentation")
    private void showLayout(@ViewState final int layoutState) {
        if (currentLayoutState == layoutState) {
            return;
        }
        currentLayoutState = layoutState;

//        final View spinnerContainer = findViewById(R.id.sp_core_meli_spinner_container);
//        final MeliSpinner spinner = findViewById(R.id.sp_core_progress_spinner);
//        final ErrorView mErrorView = findViewById(R.id.sp_core_error_view);

        hideKeyBoard(this);

        if (mContentLayout != null) {
            mContentLayout.setVisibility(GONE);
        }

        switch (currentLayoutState) {
            case PROGRESS_LAYOUT:
                processLayoutVisibility(this, true);
//                spinnerContainer.setVisibility(View.VISIBLE);
//                spinner.start();
//                mErrorView.setVisibility(View.GONE);
                break;

            case RETRY_LAYOUT:
//                showErrorView(spinnerContainer, spinner, mErrorView, R.string.sdk_error_server_title,
//                        R.string.sdk_error_server_short_subtitle, R.drawable.sdk_error_view_server, mErrorListener);
                break;

            case NETWORK_ERROR_LAYOUT:
                showErrorView(LayoutViewUtils.getInstance().getNoConnectionLayout());
//                setVisibility(VISIBLE);
//                LayoutViewUtils.getInstance().getNoConnectionLayout().setVisibility(VISIBLE);
//                processLayoutVisibility( LayoutViewUtils.getInstance().getNoConnectionLayout(), false);
//                showErrorView(spinnerContainer, spinner, mErrorView, R.string.sdk_error_connectivity_title,
//                        R.string.sdk_error_connectivity_subtitle, R.drawable.sdk_error_view_network, mErrorListener);
                break;

            case REGULAR_LAYOUT:
//                spinner.stop();
                processLayoutVisibility(this, false);
                break;
        }
    }

//    private void showErrorView(final View spinnerContainer, final MeliSpinner spinner, final ErrorView mErrorView,
//                               @StringRes final int title, @StringRes final int subtitle,
//                               @DrawableRes final int image, final OnClickListener mErrorListener) {
//        processLayoutVisibility(this, true);
//        spinner.stop();
//        spinnerContainer.setVisibility(View.GONE);
//        mErrorView.setVisibility(VISIBLE);
//
//        mErrorView.setTitle(title);
//        mErrorView.setSubtitle(subtitle);
//        mErrorView.setImage(image);
//        mErrorView.setButton(R.string.sdk_error_view_button_label, mErrorListener);
//    }

    private void showErrorView(final View spinnerContainer) {
//        processLayoutVisibility(this, true);
//        spinner.stop();

//        spinnerContainer.setLayoutParams(new LinearLayout.LayoutParams(800, 200));
        spinnerContainer.setVisibility(View.VISIBLE);
//        spinnerContainer.setMinimumHeight(200);

        Log.d("PRUEBA2", String.valueOf(spinnerContainer.getHeight()));
        Log.d("PRUEBA2", String.valueOf(spinnerContainer.getWidth()));
        Log.d("PRUEBA2", String.valueOf(spinnerContainer.getMeasuredHeight()));
        Log.d("PRUEBA2", String.valueOf(spinnerContainer.getMeasuredWidth()));
//        mErrorView.setVisibility(VISIBLE);

//        mErrorView.setTitle(title);
//        mErrorView.setSubtitle(subtitle);
//        mErrorView.setImage(image);
//        mErrorView.setButton(R.string.sdk_error_view_button_label, mErrorListener);
    }

    /**
     * Set a listener to handle the button
     * @param onErrorListener The listener
     */
    public void setOnErrorListener(final OnClickListener onErrorListener) {
        this.mErrorListener = onErrorListener;
    }

    private void processLayoutVisibility(final View layoutStateView, final boolean showLayout) {
        if (layoutStateView != null) {
            layoutStateView.animate()
                    .setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime))
                    .alpha(showLayout ? 1 : 0)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(final Animator animation) {
                            layoutStateView.setVisibility(showLayout ? View.VISIBLE : View.GONE);

                            if (mContentLayout != null) {
                                mContentLayout.setVisibility(showLayout ? View.GONE : View.VISIBLE);
                            }
                        }
                    });
        }
    }

    /**
     * Show a loading
     */
    public void showProgressLayout() {
        showLayout(PROGRESS_LAYOUT);
    }

    /**
     * Show the normal layout
     */
    public void showRegularLayout() {
        showLayout(REGULAR_LAYOUT);
    }

    /**
     * Show a retry layout
     */
    public void showRetryLayout() {
        showLayout(RETRY_LAYOUT);
    }

    /**
     * Show a network error layout
     */
    public void showNetworkErrorRefreshLayout() {
        showLayout(NETWORK_ERROR_LAYOUT);
    }

    private void hideKeyBoard(final View view) {
        if (view != null) {
            try {
                final InputMethodManager imm = (InputMethodManager) getContext().getSystemService(
                        Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } catch (final Exception exc) {
                //Do nothing
            }
        }
    }

//    private void inflateCurrentView() {
//
//        LayoutViewUtils.getInstance().getNoConnectionLayout();
//
//        final LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        inflater.inflate(R.layout.sp_core_view_layout_state, this, true);
////        setVisibility(GONE);
//
//    }
}
