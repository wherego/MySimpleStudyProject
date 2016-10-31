package com.bianl.readingwhat.util.compress;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RawRes;

import java.io.InputStream;

/**
 * Created by fhbianling on 2016/10/12.
 *
 * @mail:fhbianling@163.com
 */
public class DefaultCompressImpl implements CompressModel {
    private static DefaultCompressImpl sCompress;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case What_Success:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    if (listener!=null){
                        listener.onCompressSuccess(bitmap);
                    }
                        break;
                case What_Failed:
                    if(listener!=null){
                        listener.onCompressFailed(null);
                    }
                    break;
            }
        }
    };

    private final static int What_Success = 1;
    private final static int What_Failed = 2;

    private OnCompressListener listener;

    private DefaultCompressImpl(OnCompressListener listener) {
        this.listener = listener;
    }

    public static DefaultCompressImpl getInstance(OnCompressListener listener) {
        return new DefaultCompressImpl(listener);
    }

    @Override
    public void compressBitmap(Context context, final String filePath, final int inSampleSize) {
        new Thread() {
            @Override
            public void run() {
                BitmapFactory.Options opts = new BitmapFactory.Options();
                opts.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(filePath, opts);
                opts.inPreferredConfig = Bitmap.Config.RGB_565;
                opts.inPurgeable = true;
                opts.inInputShareable = true;

                opts.inSampleSize = inSampleSize;
                opts.inJustDecodeBounds = false;
                Bitmap bitmap = BitmapFactory.decodeFile(filePath, opts);
                Message obtain = Message.obtain();
                if (bitmap != null) {
                    obtain.obj = bitmap;
                    obtain.what = What_Success;
                    handler.sendMessage(obtain);
                } else {
                    obtain.what = What_Failed;
                    handler.sendMessage(obtain);
                }
            }
        }.start();
    }

    @Override
    public void compressBitmap(Context context, @RawRes int imgId) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inPreferredConfig = Bitmap.Config.RGB_565;
        opts.inPurgeable = true;
        opts.inInputShareable = true;

        InputStream is = context.getResources().openRawResource(imgId);
        if (listener != null) {
            listener.onCompressSuccess(BitmapFactory.decodeStream(is, null, opts));
        }
    }

}
