package com.bianl.readingwhat.rx;

/**
 * Created by fhbianling on 2016/11/10.
 *
 * @mail:fhbianling@163.com
 */
public enum RxEvent {
    GoMovie {
        @Override
        public void setTag(Object tag) {
            this.tag = tag;
        }
    },
    GoBook {
        @Override
        public void setTag(Object tag) {
            this.tag = tag;
        }
    };

    public Object tag;

    public abstract void setTag(Object tag);

}
