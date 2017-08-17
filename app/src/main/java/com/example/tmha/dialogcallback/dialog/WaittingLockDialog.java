package com.example.tmha.dialogcallback.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.view.Window;

import com.example.tmha.dialogcallback.R;

/**
 * Created by tmha on 8/17/2017.
 */

public class WaittingLockDialog extends Dialog{

    private CallBack mCallBack;

    private CountDownTimer mCountDownTimer;

    public WaittingLockDialog(@NonNull Context context, CallBack mCallBack) {
        super(context);
        initView();
        this.mCallBack = mCallBack;
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.waiting_lock_dialog);
        setCanceledOnTouchOutside(false);

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

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);

    }

    public interface CallBack{
        void callBack();
    }

    @Override
    public void onBackPressed() {

    }
}
