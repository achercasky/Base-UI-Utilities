package com.achercasky.base.ui;

import android.view.View;

/**
 * Created by achercasky on 15/03/2018.
 */

public class LayoutViewUtils {

    private static final LayoutViewUtils INSTANCE = new LayoutViewUtils();

    private View noConnectionLayout;

    public static LayoutViewUtils getInstance() {
        return INSTANCE;
    }

    public void setNoConnectionLayout(final View noConnectionLayout) {
        this.noConnectionLayout = noConnectionLayout;
    }

    public View getNoConnectionLayout() {
        return noConnectionLayout;
    }
}
