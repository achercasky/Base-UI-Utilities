package com.achercasky.base.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.achercasky.base.ui.utils.State;

/**
 * Created by achercasky on 13/03/2018.
 */

public class LayoutStateView extends StatefulLayout{

    private String mInitialState = State.CONTENT;
    private boolean mTransitionsEnabled = true;

    public LayoutStateView(@NonNull final Context context) {
        super(context);
        init(context, null);
    }

    public LayoutStateView(@NonNull final Context context, @Nullable final AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LayoutStateView(@NonNull final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @Override
    protected void onSetupContentState() {
        super.onSetupContentState();
        if(mInitialState != null)
            setState(mInitialState);
    }
    @SuppressLint("NewApi")
    @Override
    public void setState(String state) {
        if(isTransitionsEnabled())
            TransitionManager.beginDelayedTransition(this);
        super.setState(state);
    }

    public void showContent() {
        setState(State.CONTENT);
    }


    public void showProgress() {
        setState(State.PROGRESS);
    }


    public void showOffline() {
        setState(State.OFFLINE);
    }


    public void showEmpty() {
        setState(State.EMPTY);
    }

    public boolean isTransitionsEnabled() {
        return mTransitionsEnabled;
    }


    public void setTransitionsEnabled(boolean transitionsEnabled) {
        mTransitionsEnabled = transitionsEnabled;
    }


    private void init(Context context, AttributeSet attrs) {
//        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SflStatefulLayout);

        final LayoutViewUtils layoutViewUtils = LayoutViewUtils.getInstance();
//
//        int offlineLayoutResource = a.getResourceId(R.styleable.SflStatefulLayout_offlineLayout, R.layout.sfl_default_placeholder_offline);
//        int emptyLayoutResource = a.getResourceId(R.styleable.SflStatefulLayout_emptyLayout, R.layout.sfl_default_placeholder_empty);
//        int progressLayoutResource = a.getResourceId(R.styleable.SflStatefulLayout_progressLayout, R.layout.sfl_default_placeholder_progress);

        setStateView(State.OFFLINE, layoutViewUtils.getNoConnectionLayout());

//        int textAppearance = a.getResourceId(R.styleable.SflStatefulLayout_stateTextAppearance, R.style.sfl_TextAppearanceStateDefault);
//        setTextAppearance(textAppearance);

        // setState custom empty text
//        if(a.hasValue(R.styleable.SflStatefulLayout_emptyText)) {
//            setEmptyText(a.getString(R.styleable.SflStatefulLayout_emptyText));
//        }
//
//        // setState custom offline text
//        if(a.hasValue(R.styleable.SflStatefulLayout_offlineText)) {
//            setOfflineText(a.getString(R.styleable.SflStatefulLayout_offlineText));
//        }
//
//        // setState custom offline retry text
//        if(a.hasValue(R.styleable.SflStatefulLayout_offlineRetryText)) {
//            setOfflineText(a.getString(R.styleable.SflStatefulLayout_offlineRetryText));
//        }
//
//        if(a.hasValue(R.styleable.SflStatefulLayout_offlineImageDrawable)) {
//            setOfflineImageResource(a.getResourceId(R.styleable.SflStatefulLayout_offlineImageDrawable, 0));
//        }
//
//        if(a.hasValue(R.styleable.SflStatefulLayout_emptyImageDrawable)) {
//            setEmptyImageResource(a.getResourceId(R.styleable.SflStatefulLayout_emptyImageDrawable, 0));
//        }
//
//        // getState initial state if setState
//        if(a.hasValue(R.styleable.SflStatefulLayout_state)) {
//            mInitialState = a.getString(R.styleable.SflStatefulLayout_state);
//        }
//
//        a.recycle();
    }
}
