package com.xiaoxiao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiaoxiao
 * @create 2021-01-23 23:22
 */
public class DateFormatUtil {
    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat ymdhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public static String formatYMD(Date date) {
        return ymd.format(date);
    }

    public static Date toDateYMD(String date) throws ParseException {
        return ymd.parse(date);
    }

    public static String formatYMDHm(Date date) {
        return ymdhm.format(date);
    }

    public static Date toDateYMDHm(String date) throws ParseException {
        return ymdhm.parse(date);
    }
}
