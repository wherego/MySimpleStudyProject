package com.bianl.readingwhat.util.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;

/**
 * Created by fhbianling on 2016/10/12.
 *
 * @mail:fhbianling@163.com
 */
public interface CompressModel {
    public interface OnCompressListener{
        void onCompressSuccess(Bitmap bitmap);
        void onCompressFailed(@Nullable Exception e);
    }

    public interface OnCompressFileListener{
        void onCompressFileSuccess();
        void onCompressFileFailed(Exception e);
    }

    void compressBitmap(Context context, String url, int inSampleSize);
    void compressBitmap(Context context, int imgId);

}
