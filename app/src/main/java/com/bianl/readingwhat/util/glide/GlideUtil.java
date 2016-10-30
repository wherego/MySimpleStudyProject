package com.bianl.readingwhat.util.glide;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import com.bianl.readingwhat.util.L;
import com.bianl.readingwhat.util.ScreenUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class GlideUtil {
    private GlideUtil() {
    }

    public static void loadImage(Activity activity, String url, ImageView target) {
        Glide.with(activity).
                load(url).
                crossFade().
                diskCacheStrategy(DiskCacheStrategy.ALL).
                into(target);
    }

    public static void loadImageWithOrginScale(final Activity activity, final String url, final ImageView target) {
        Glide.with(activity).load(url).asBitmap().into(new SimpleTarget<Bitmap>(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL) {
            @Override
            public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                float resouceWidth = resource.getWidth();
                float resouceHeight = resource.getHeight();
                try {
                    target.getRootView().measure(0, 0);
//                target.measure(0,0);
                    int targetWidth = target.getMeasuredWidth();
                    int targetHeight = target.getMeasuredHeight();
                    float scale = resouceWidth / resouceHeight;
                    ViewGroup.LayoutParams para = target.getLayoutParams();
                    L.d("Scale:" + scale + ",wh:" + resouceWidth + "|" + resouceHeight);
                    L.d("targetWh:" + targetWidth + "|" + targetHeight);

                    if (targetWidth <= targetHeight && targetWidth != 0) {
                        para.height = (int) (targetWidth / scale);
                        L.d("paramChangeHeight:" + para.height);
                    } else if (targetWidth > targetHeight && targetHeight != 0) {
                        para.width = (int) (targetHeight * scale);
                        L.d("paramChangeWidth" + para.width);
                    }

                    target.setLayoutParams(para);
//                Glide.with(activity).load(url).asBitmap().into(target);
                    target.setImageBitmap(resource);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
