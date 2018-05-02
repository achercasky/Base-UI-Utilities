package com.achercasky.sample.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ViewGroup;
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
        this.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
//        int parentWidth = MeasureSpec.getSize(widthMeasureSpec);
//        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
//        this.setMeasuredDimension(parentWidth/2, parentHeight);
//        this.setLayoutParams(new LinearLayout.LayoutParams(parentWidth/2,parentHeight));
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
//        int myWidth = (int) (parentHeight * 0.5);
//        super.onMeasure(MeasureSpec.makeMeasureSpec(myWidth, MeasureSpec.EXACTLY), heightMeasureSpec);
//    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        int parentHeight = MeasureSpec.getSize(heightMeasureSpec);
//        int myWidth = (int) (parentHeight * 0.5);
//        super.onMeasure(MeasureSpec.makeMeasureSpec(myWidth, MeasureSpec.EXACTLY), heightMeasureSpec);
//    }
}
