package com.achercasky.base.ui.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.achercasky.base.ui.R;

/**
 * Created by aribr on 05/05/2017.
 */

public class ProgressAnimView extends RelativeLayout {

    public static final String ROTATE_MODE = "rotate";
    public static final String FLIP_MODE = "flip";
    public static final String VIBRATE_MODE = "vibrate";
    public static final String SHAKE_MODE = "shake";

    public static final String BOUNCE_MODE = "bounce";


    private LinearLayout progressViewStart;
    private LinearLayout progressViewFailed;

    private ImageView loaderImage;

    private TextView loaderTitle;

    private ImageView imageError;
    private TextView textError;
    private TypedArray array;
    private Context mContext;
    private Typeface typeface;
    private Animation myRotation;
    private Animation myFlip;
    private Animation myVibrate;
    private Animation myShake;
    private Animation myBounce;

    private View view;

//    private Callback callback;

    public ProgressAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);

        inflate(getContext(), R.layout.ui_progress_anim, this);

        mContext = context;
        initView();
    }

    private void initView() {

        loaderImage = findViewById(R.id.ui_progress_anim_image);

        loaderTitle = findViewById(R.id.ui_progress_anim_title);

        setLoadingAnimationMode(FLIP_MODE);
    }

    public void customizeProgress(@NonNull final String title, @NonNull final int drawableImage) {
        loaderImage.setImageResource(drawableImage);
        loaderTitle.setText(title);
    }

//    public void setCallback(Callback callback) {
//        this.callback = callback;
//    }

//    // method attribut
//    public void setTextSize(int i) {
//        if (i != 0) {
//            textError.setTextSize(TypedValue.COMPLEX_UNIT_SP, i);
//            textLoading.setTextSize(TypedValue.COMPLEX_UNIT_SP, i);
//            //Toast.makeText(mContext,i+"",Toast.LENGTH_LONG).show();
//        } else {
//            textError.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
//            textLoading.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
//        }
//    }
//
//    public void setTextLoading(String s) {
//        if (!TextUtils.isEmpty(s)) {
//            textLoading.setText(s);
//        } else {
//            textLoading.setText("cargando");
//        }
//    }

    public void setLoadingAnimationMode(String s) {
        myRotation = AnimationUtils.loadAnimation(mContext, R.anim.rotate_anim);
        myFlip = AnimationUtils.loadAnimation(mContext, R.anim.flip_anim);
//        myVibrate = AnimationUtils.loadAnimation(mContext, R.anim.vibrate_anim);
//        myShake = AnimationUtils.loadAnimation(mContext, R.anim.shake_anim);
        myBounce = AnimationUtils.loadAnimation(mContext, R.anim.bounce_anim);
        if (!TextUtils.isEmpty(s)) {
            switch (s.toLowerCase()) {
                case ROTATE_MODE:
                    loaderImage.startAnimation(myRotation);
                    break;
                case FLIP_MODE:
                    loaderImage.startAnimation(myFlip);
                    break;
//                case VIBRATE_MODE:
//                    imageLoading.startAnimation(myVibrate);
//                    break;
//                case SHAKE_MODE:
//                    imageLoading.startAnimation(myShake);
//                    break;
                case BOUNCE_MODE:
                    loaderImage.startAnimation(myBounce);
                    break;
                default:
                    loaderImage.startAnimation(myRotation);
                    break;
            }
        } else {
            loaderImage.startAnimation(myFlip);
        }
    }

    public void setOnRetry(OnClickListener v) {
        progressViewFailed.setOnClickListener(v);
    }

//    public void startProgress() {
//        imageLoading.setBackgroundResource(R.mipmap.ic_launcher);
//        progressView.setVisibility(View.VISIBLE);
//        setLoadingAnimationMode(FLIP_MODE);
//        textLoading.setVisibility(View.GONE);
//        sync.setVisibility(View.GONE);
////        progressViewStart.setVisibility(View.VISIBLE);
////        progressViewFailed.setVisibility(View.GONE);
//    }

//    public void stopProgress() {
//        progressView.setVisibility(View.GONE);
////        progressViewStart.setVisibility(View.GONE);
////        progressViewFailed.setVisibility(View.GONE);
//    }

//    public void noConnection() {
//        sync.setVisibility(View.VISIBLE);
//        imageLoading.clearAnimation();
//        imageLoading.setBackgroundResource(R.drawable.ic_no_connection);
//        textLoading.setVisibility(View.VISIBLE);
//        textLoading.setText(R.string.no_internet_connection);
//
//
//        sync.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                callback.onRetry();
//            }
//        });
//    }
}
