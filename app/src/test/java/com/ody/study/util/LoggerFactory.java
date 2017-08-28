package com.ody.study.util;

import static android.R.attr.format;

/**
 * Created by sunhuahui on 2017/8/24.
 */

public enum LoggerFactory {

    INSTANCE;

    public void info(String format, Object value) {
        System.out.println(format.substring(0, format.length() - 1) + value + format.substring(format.length() - 1));
    }

    public void info(Object value) {
        System.out.println(value);
    }
}
