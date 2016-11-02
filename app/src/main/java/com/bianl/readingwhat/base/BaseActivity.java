package com.bianl.readingwhat.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.bianl.readingwhat.util.ToastUtil;
import com.bianl.readingwhat.util.TypeUtil;

import butterknife.ButterKnife;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public abstract class BaseActivity<P extends BasePrensenter, M extends BaseModel> extends AppCompatActivity implements DialogInterface.OnCancelListener,BaseView {
    protected final static String START_INT1="STR_INT1";
    protected final static String START_STRING="STR_STR";

    protected M mModel;
    protected P mPrensenter;

    protected abstract
    @LayoutRes
    int bindLayoutId();

    protected abstract void initView();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayoutId());
        ButterKnife.bind(this);
        mPrensenter = TypeUtil.getT(this, 0);
        mModel = TypeUtil.getT(this, 1);
        if (mModel != null) {
            mPrensenter.setMv(mModel, this);
        }
        initView();
    }

    protected void showMsg(String message) {
        ToastUtil.showMessage(this, message);
    }

    private ProgressDialog mProgressDialog;

    protected void showProgressDialog(String message) {
        if (!TextUtils.isEmpty(message)) {
            mProgressDialog = ProgressDialog.show(this, null, message, true, true);
            mProgressDialog.setOnCancelListener(this);
        }
    }

    @Override
    public void onCancel(DialogInterface dialogInterface) {
        hideProgress();
    }

    protected void hideProgress() {
        if (mProgressDialog != null) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        hideProgress();
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        showProgressDialog("DataLoading");
    }

    @Override
    public void endLoading() {
        hideProgress();
    }

    @Override
    public void showErrorMessage(String message) {
        showMsg(message);
    }

}
