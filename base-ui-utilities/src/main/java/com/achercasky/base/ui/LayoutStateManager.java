package com.achercasky.base.ui;

import android.view.View;

/**
 * Created by achercasky on 14/03/2018.
 */

public class LayoutStateManager {

    private static final LayoutStateManager INSTANCE = new LayoutStateManager();

    private static final LayoutViewUtils utils = LayoutViewUtils.getInstance();

    private View noConnectionLayout;

    private static final Builder BUILDER = new Builder();

    public static Builder init() {
        return BUILDER;
    }

    private LayoutStateManager() {
//        throw new AssertionError("Should not create instance of the class");
    }

    public void setNoConnectionLayout() {
    }

    public void setEmptyLayout() {
    }

    public View getNoConnectionLayout() {
        return noConnectionLayout;
    }

    public static class Builder {

        private View noConnectionLayout;
        private int emptyLayout;

        public Builder() {
        }

//        public Builder setNoConnectionLayout(final int noConnectionLayout) {
//            this.noConnectionLayout = noConnectionLayout;
//            return this;
//        }

        public Builder setNoConnectionLayout(final View noConnectionLayout) {
            this.noConnectionLayout = noConnectionLayout;
            utils.setNoConnectionLayout(noConnectionLayout);
            return this;
        }

        public Builder setEmptyLayout(final int emptyLayout) {
//            this.emptyLayout = emptyLayout;
//            utils.setNoConnectionLayout(emptyLayout);
            return this;
        }

        public LayoutStateManager create() {
            INSTANCE.noConnectionLayout = noConnectionLayout;
            return INSTANCE;
        }
    }


}
