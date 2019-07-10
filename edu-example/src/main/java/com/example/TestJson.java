package com.example;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2018/12/24
 */
public class TestJson {

    public static void main(String[] args) {
//        String timeA = "12:13:12";
//        String timeB = "12:12:11";
//        String timeC = "12:12:10";
//
//
//        System.out.println(timeA.compareTo(timeB));
//        System.out.println(timeA.compareTo(timeC));
//        System.out.println(timeB.compareTo(timeC));

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String curtime = sdf.format(new Date());

        String start = "23:12:12";
        String end = "22:22:22";
        if (curtime.compareTo(start) > 0 && curtime.compareTo(end) < 0) {
            System.out.println(1);
        }else {
            System.out.println(2);
        }

        System.out.println("1".equals(String.valueOf(1L)));

        String s = "148";
        int mod = Integer.parseInt(s.substring(s.length()-2,s.length()));
        System.out.println(mod%10);

    }
}
