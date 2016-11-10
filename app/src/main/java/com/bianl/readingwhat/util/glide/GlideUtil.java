package com.bianl.readingwhat.util.glide;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
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
                float originWidth = resource.getWidth();
                float originHeight = resource.getHeight();
                try {
                    target.getRootView().measure(0, 0);
                    int targetWidth = target.getMeasuredWidth();
                    int targetHeight = target.getMeasuredHeight();
                    float scale = originWidth / originHeight;
                    ViewGroup.LayoutParams para = target.getLayoutParams();

                    if (targetWidth <= targetHeight && targetWidth != 0) {
                        para.height = (int) (targetWidth / scale);
                    } else if (targetWidth > targetHeight && targetHeight != 0) {
                        para.width = (int) (targetHeight * scale);
                    }

                    target.setLayoutParams(para);
                    target.setImageBitmap(resource);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
