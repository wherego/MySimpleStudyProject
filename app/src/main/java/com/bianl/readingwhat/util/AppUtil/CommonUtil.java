package com.bianl.readingwhat.util.AppUtil;

import com.bianl.readingwhat.bean.movie.Staff;

import java.util.List;

/**
 * Created by fhbianling on 2016/10/30.
 *
 * @mail:fhbianling@163.com
 */
public class CommonUtil {
    private CommonUtil() {
    }

    public static String getGenresInLine(List<String> genrics) {
        if (genrics == null||genrics.isEmpty()) {
            return null;
        }
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < genrics.size(); i++) {
            sB.append(genrics.get(i));
            if (i != genrics.size() - 1) {
                sB.append(",");
            }
        }
        return sB.toString();
    }
    public static String getCastNameInLine(List<Staff> staffs,int max) {
        if (staffs == null||staffs.isEmpty()) {
            return null;
        }
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < Math.min(staffs.size(),max); i++) {
            sB.append(staffs.get(i).getName());
            if (i != staffs.size() - 1) {
                sB.append(",");
            }
        }
        return sB.toString();
    }
}
