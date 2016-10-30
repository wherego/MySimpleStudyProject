package com.bianl.readingwhat.net;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by fhbianling on 2016/10/16.
 *
 * @mail:fhbianling@163.com
 */
public class NetRequest<T> implements DialogInterface.OnCancelListener {

    private ProgressDialog mDialog;

    private Call<T> mCall;

    public NetRequest() {

    }

    public NetRequest(Context context, @Nullable String message) {
        if (!TextUtils.isEmpty(message)) {
            mDialog = ProgressDialog.show(context, "", message, true, true);
            mDialog.setOnCancelListener(this);
        }
    }


    public void enqueue(@NonNull Call<T> call, @NonNull final OnResponseListener<T> listener) {
        this.mCall = call;
        call.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {
                hideProgress();
                if (response != null) {
                    listener.onSuccessResponse(response.body());
                } else {
                    listener.onFailedResponse();
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                hideProgress();
                listener.onFailedResponse();
                Log.d("OkHttp", t != null ? t.getMessage() : "onFailure");
            }
        });
    }

    @Override
    public void onCancel(DialogInterface dialog) {

        if (mDialog != null && mCall != null) {
            mCall.cancel();
        }
    }


    private void hideProgress() {

        if (mDialog != null) {
            mDialog.dismiss();
            mDialog = null;
        }

    }
}
