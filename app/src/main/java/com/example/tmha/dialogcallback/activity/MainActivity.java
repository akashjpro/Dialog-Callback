package com.example.tmha.dialogcallback.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmha.dialogcallback.R;
import com.example.tmha.dialogcallback.dialog.ConfirmDialog;
import com.example.tmha.dialogcallback.dialog.InfoDialog;
import com.example.tmha.dialogcallback.dialog.WaitingDialog;
import com.example.tmha.dialogcallback.dialog.WaittingLockDialog;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtWaiting;
    private WaitingDialog mWaitingDialog;
    private ConfirmDialog mConfirmDialog;
    private InfoDialog mInfoDialog;
    private WaittingLockDialog mWaittingLockDialog;
    private TextView mTxtDeviceModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxtWaiting = (TextView) findViewById(R.id.txtWaiting);
        mTxtDeviceModel = (TextView) findViewById(R.id.txtDeviceModel);

        String reqString = Build.MANUFACTURER
                + " " + Build.MODEL + " " + Build.VERSION.RELEASE
                + " " + Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();
        mTxtDeviceModel.setText(reqString);
    }

    public void waitingClick(View view) {
        mTxtWaiting.setText("");
        mTxtWaiting.setVisibility(View.GONE);
        mWaitingDialog = new WaitingDialog(this, new WaitingDialog.CallBack() {
            @Override
            public void callBack() {
                mTxtWaiting.setVisibility(View.VISIBLE);
                mTxtWaiting.setText("Đã hết 10s");
                mWaitingDialog.dismiss();
            }
        });

        mWaitingDialog.show();
    }

    public void confirmClick(View view) {
        mConfirmDialog = new ConfirmDialog(this, new ConfirmDialog.CallBack() {
            @Override
            public void callBack(boolean isYes) {
                if (isYes){
                    Toast.makeText(MainActivity.this, "Yes", Toast.LENGTH_SHORT).show();
                    mConfirmDialog.dismiss();
                }else{
                    Toast.makeText(MainActivity.this, "No", Toast.LENGTH_SHORT).show();
                    mConfirmDialog.dismiss();
                }
            }
        });

        mConfirmDialog.show();
    }

    public void infoClick(View view) {
        mInfoDialog = new InfoDialog(this, new InfoDialog.CallBack() {
            @Override
            public void callBack() {
                startActivity(new Intent(MainActivity.this, InfoActivity.class));
                mInfoDialog.dismiss();
            }
        });

        mInfoDialog.show();
    }

    public void waitinfLockClick(View view) {
        mWaittingLockDialog = new WaittingLockDialog(this, new WaittingLockDialog.CallBack() {
            @Override
            public void callBack() {
                mWaittingLockDialog.dismiss();
            }
        });

        mWaittingLockDialog.show();

    }
}
