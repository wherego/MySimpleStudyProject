package com.bianl.readingwhat.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class TypeUtil {

    public static <T> T getT(Object o, int i) {
//        try {
//            Type genericSuperclass1 = o.getClass().getGenericSuperclass();
//            if(genericSuperclass1 instanceof ParameterizedType){
//                ParameterizedType genericSuperclass = (ParameterizedType) genericSuperclass1;
//                Type type = genericSuperclass.getActualTypeArguments()[i];
//                Class<T> aClass = (Class<T>) type.getClass();
//                L.d(aClass.getName());
//                return aClass.newInstance();
//            }
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (ClassCastException e) {
//            e.printStackTrace();
//        }
//        return null;
        try {
            Class<T> tClass = (Class<T>) ((ParameterizedType) (o.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[i];
            return tClass
                    .newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
