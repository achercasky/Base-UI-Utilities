package com.achercasky.sample.ui;

import android.app.Application;

import com.achercasky.base.ui.LayoutStateManager;

/**
 * Created by achercasky on 14/03/2018.
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        LayoutStateManager.init()
//                .setEmptyLayout(1)
                .setNoConnectionLayout(new SampleView(getApplicationContext()))
                .create();
    }
}
