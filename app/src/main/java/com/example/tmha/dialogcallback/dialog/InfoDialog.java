package com.example.tmha.dialogcallback.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.tmha.dialogcallback.R;

/**
 * Created by tmha on 8/17/2017.
 */

public class InfoDialog extends Dialog {

    private CallBack mCallBack;
    private Button mBtnYes;

    public InfoDialog(@NonNull Context context, CallBack mCallBack) {
        super(context);
        initView();
        this.mCallBack = mCallBack;
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.info_dialog);
        setCanceledOnTouchOutside(false);
        mBtnYes = findViewById(R.id.btn_yes);

        mBtnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCallBack.callBack();
            }
        });

    }

    public interface CallBack{
        void callBack();
    }
}
