package com.example;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/4/1
 */
public class ListRemove {

    public static void main(String[] args) {

        String authDataJson = "{\"source\":\"JF_APP_CASH_LOAN\",\"authTime\":\"20181219184113\",\"authChannel\":\"魔盒\",\"comeFromAuth\":false,\"mobile\":\"15109683128\",\"facilitator\":2,\"taskId\":\"\"null\"\",\"status\":3}";
        Map map = JSONObject.parseObject(authDataJson, Map.class);
        System.out.println(JSONObject.toJSONString(map));

        List<String> list = new ArrayList();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        list.add("12345");
        list.add("123456");

//        for (int i = list.size() -1; i>=0;i--) {
//            if (list.get(i).equals("123")) {
//                list.remove("123");
//            }
//        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (value.equals("123")) {
                iterator.remove();
            }
        }
        System.out.println(JSONObject.toJSONString(list));
    }
}
