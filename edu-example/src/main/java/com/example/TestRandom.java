package com.example;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/4/9
 */
public class TestRandom {
    public static void main(String[] args) {
        int randomPerson = (new Random()).nextInt(6500) + 9000;
        int randomWaitTime = randomPerson / 100;
        int waitTime = (int) Math.floor(randomWaitTime);
        int randomSpentTime = (new Random()).nextInt(20) + 10;
        int spentTime = waitTime - randomSpentTime;
        Map<String, Object> result = new HashMap<>();
        result.put("personNum", randomPerson);
        result.put("waitTime", waitTime);
        result.put("spentTime", spentTime);

        System.out.println(JSONObject.toJSONString(result));
        System.out.println("=============================");

        int randomPerson2 = (new Random()).nextInt(6500) + 9000;
        System.out.println(randomPerson2);


        for (int i = 0; i < 9999; i++) {
            int num = get_random(6500, 15000);

            if (num > 15000) {
                System.out.println("error");
            }
            System.out.println(num);
        }


    }

    public static int get_random(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    public static void addEle(List list) {
        list.add(String.valueOf(list.size() + 1));
    }
}
