package com.bianl.readingwhat.base;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.bianl.readingwhat.R;
import com.bianl.readingwhat.rx.AppRxSchedulers;
import com.bianl.readingwhat.rx.RxBus;
import com.bianl.readingwhat.rx.RxEvent;
import com.bianl.readingwhat.util.L;
import com.bianl.readingwhat.util.ToastUtil;
import com.bianl.readingwhat.util.TypeUtil;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public abstract class BaseActivity<P extends BasePrensenter, M extends BaseModel> extends SwipeBackActivity implements DialogInterface.OnCancelListener, BaseView {
    protected final static String START_INT1 = "STR_INT1";
    protected final static String START_STRING = "STR_STR";

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
        AppManager.getInstance().addActivity(this);
        ButterKnife.bind(this);

        mPrensenter = TypeUtil.getT(this, 0);
        mModel = TypeUtil.getT(this, 1);
        if (mModel != null) {
            mPrensenter.setMv(mModel, this);
        }
        initView();
        startHandleMessage();
    }

    private void startHandleMessage() {
        RxBus.getInstance().toObservable().filter(new Func1<Object, Boolean>() {
            @Override
            public Boolean call(Object o) {
                return o instanceof RxEvent;
            }
        }).map(new Func1<Object, RxEvent>() {
            @Override
            public RxEvent call(Object o) {
                return (RxEvent) o;
            }
        }).compose(AppRxSchedulers.<RxEvent>ioMain()).subscribe(new Action1<RxEvent>() {
            @Override
            public void call(RxEvent rxEvent) {
                handleMessage(rxEvent);
            }
        });
    }

    protected void handleMessage(RxEvent rxEvent) {

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
        AppManager.getInstance().removeActivity(this);
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
