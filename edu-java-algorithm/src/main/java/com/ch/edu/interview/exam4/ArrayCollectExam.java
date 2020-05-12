package com.ch.edu.interview.exam4;

import com.alibaba.fastjson.JSONObject;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * //评测题目(30分钟):
 * /*
 * 问题：
 * 用户界面需要显示一个信息列表，信息来源有2部分。
 * 一部分是系统给他发的系统消息列表（sysInfo），一部分是推荐系统给出的推荐消息列表(recommendInfo)。
 * 给定的系统消息列表和推荐消息列表分别最多10条，请返回产品经理要求的消息列表。
 * <p>
 * 产品经理的需求如下：
 * 1、返回的消息列表总数最多10条消息；
 * 2、保证返回的消息列表中，系统消息数最多连续出现3条；
 * 3、保证返回的消息列表的总质量分最高；
 * <p>
 * 请使用c++或java语言完成如下函数，并保持逻辑正确、代码优雅，可以使用外部函数包，
 * 纯文本编辑下允许存在少量编译问题：
 * <p>
 * <p>
 * <p>
 * 其中Info类主要包含：
 * class Info{
 * int msgId;
 * int score; //质量分
 * int type; //0为系统消息，1为推荐消息
 * }
 */
public class ArrayCollectExam {

    public static void main(String[] args) {
//        method_1();

        method_2();
    }

    private static int sysFlag = 0;

    private static void method_2() {

        List<Info> syslist = getListSys().stream().sorted(Comparator.comparingInt(Info::getScore).reversed()).collect(Collectors.toList());
        List<Info> collect = getListRon().stream().sorted(Comparator.comparingInt(Info::getScore).reversed()).collect(Collectors.toList());


        LinkedBlockingDeque<Info> queueSys = new LinkedBlockingDeque<>();
        syslist.forEach(i -> queueSys.add(i));

        LinkedBlockingDeque<Info> queueRec = new LinkedBlockingDeque<>();
        collect.forEach(i -> queueRec.add(i));

        List<Info> result = new ArrayList<>();
        while (result.size() < 10) {
            if (queueSys.peek().getScore() >= queueRec.peek().getScore() && sysFlag < 2) {
                result.add(queueSys.poll());
                sysFlag += 1;
                System.out.println("添加 queueSys sysFlag: " + sysFlag + " size:" + result.size());

            } else {
                result.add(queueRec.poll());
                sysFlag = 0;
                System.out.println("添加 queueRec sysFlag: " + sysFlag + " size:" + result.size());
            }
        }

        System.out.println(">> " + JSONObject.toJSONString(result));

    }

    private static void method_1() {
        List<Info> syslist = getListSys().stream().sorted(Comparator.comparingInt(Info::getScore).reversed()).collect(Collectors.toList());
        List<Info> collect = getListRon().stream().sorted(Comparator.comparingInt(Info::getScore).reversed()).collect(Collectors.toList());

        List<Info> newList = new ArrayList<>();
        syslist.stream().filter(i -> {
            if (i.getMsgId() % 3 == 0) {
                newList.add(collect.get(0));
                collect.remove(collect.get(0));
            }
            newList.add(i);
            return true;
        }).limit(8).collect(Collectors.toList());

        System.out.println(JSONObject.toJSONString(syslist));
        System.out.println(JSONObject.toJSONString(collect));
        System.out.println(">> " + JSONObject.toJSONString(newList));
    }

    private static List<Info> getListRon() {
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Info info = new Info();
            info.setMsgId(i);
            info.setScore(new Random().nextInt(100));
            info.setType(1);
            list.add(info);
        }
        return list;
    }

    private static List<Info> getListSys() {
        List<Info> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Info info = new Info();
            info.setMsgId(i);
            info.setScore(new Random().nextInt(100));
            info.setType(0);
            list.add(info);
        }
        return list;
    }

}

