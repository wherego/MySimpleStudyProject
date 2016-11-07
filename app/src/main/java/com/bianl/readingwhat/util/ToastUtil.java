package com.bianl.readingwhat.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bianl.readingwhat.R;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class ToastUtil {
    private ToastUtil() {
    }

    @SuppressLint("InflateParams")
    public static void showMessage(Context context, String message,int duration){
        Toast sToast=new Toast(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.msg_toast, null);
        sToast.setView(inflate);
        sToast.setGravity(Gravity.CENTER,0,0);
        TextView tv= (TextView) sToast.getView().findViewById(R.id.toast_tv);
        tv.setText(message);
        sToast.setDuration(duration);
        sToast.show();
    }
    public static void showMessage(Context context,String message){
        showMessage(context,message,Toast.LENGTH_SHORT);
    }
}
