package com.queue.demo1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    //把long型time时间转化为人类可读的字符串。
    public static String timeUtil(long t) {
        SimpleDateFormat format = new SimpleDateFormat("mm:ss:SS");
        Date date = new Date();
        date.setTime(t);
        return format.format(date);
    }
}
