package com.example.tmha.dialogcallback.dialog;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.example.tmha.dialogcallback.R;

/**
 * Created by tmha on 8/17/2017.
 */

public class WaitingDialog extends Dialog {
    
    private ProgressBar mProgressBar;
    private CallBack mCallBack;

    private CountDownTimer mCountDownTimer;
    
    public WaitingDialog(@NonNull Context context, CallBack mCallBack) {
        super(context);
        initView();
        this.mCallBack = mCallBack;
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.waiting_dialog);
        setCanceledOnTouchOutside(false);
        mProgressBar = findViewById(R.id.circular_progress_bar);

        mCountDownTimer =  new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
               mCallBack.callBack();
            }
        };

        mCountDownTimer.start();

        ObjectAnimator anim = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
        anim.setDuration(100);
        anim.setInterpolator(new DecelerateInterpolator());
        anim.start();
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    public interface CallBack{
        void callBack();
    }
}
