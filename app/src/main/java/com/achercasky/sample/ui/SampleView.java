package com.achercasky.sample.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by achercasky on 18/03/2018.
 */

public class SampleView extends LinearLayout {

    public SampleView(Context context) {
        super(context);
        init();
    }

    public SampleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.item_near_venues, this);
    }

}
