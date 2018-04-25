package com.achercasky.base.ui.listeners;

/**
 * Created by achercasky on 19/03/2018.
 */

public interface OnChangeStateLayoutListener {

    void showLoader();

    void showContent();

    void showRetry();

    void showNetworkError();

    int getCurrentStateLayout();
}
