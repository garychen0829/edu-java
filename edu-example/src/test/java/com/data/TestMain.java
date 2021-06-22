package com.data;

import com.google.gson.Gson;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain {
    private static Gson gson = new Gson();

    @Test
    public void test0() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO vo1 = new ParamVO();
        vo1.setName("无电话");
        vo1.setValue(88);
        data.add(vo1);

        vo1 = new ParamVO();
        vo1.setName("已联");
        vo1.setValue(323);
        data.add(vo1);

        vo1 = new ParamVO();
        vo1.setName("总计");
        vo1.setValue(413);
        data.add(vo1);

        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

    }


    @Test
    public void test1() {
        List<ParamVO> data1 = new ArrayList<>();
        ParamVO p1 = new ParamVO();
        p1.setName("其他类");
        p1.setValue(1);
        data1.add(p1);

        p1 = new ParamVO();
        p1.setName("求助类");
        p1.setValue(130);
        data1.add(p1);

        p1 = new ParamVO();
        p1.setValue(231);
        p1.setName("投诉类");
        data1.add(p1);

        p1 = new ParamVO();
        p1.setValue(20);
        p1.setName("意见建议类");
        data1.add(p1);

        p1 = new ParamVO();
        p1.setValue(31);
        p1.setName("求助类");
        data1.add(p1);

        p1 = new ParamVO();
        p1.setValue(413);
        p1.setName("总计");
        data1.add(p1);

        System.out.println("data:" + gson.toJson(data1)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));


    }

    @Test
    public void test2() {
        String[] str = new String[]{"公安政法类", "公用事业类", "供水报修类", "建设交通类", "经济综合类", "科教文卫类", "其他类", "社会管理类", "社会噪声类", "市容市貌类", "卫生信息类", "物业安保类", "物业服务管理类", "物业相关执法类", "消防管理类", "噪音污染类", "住房保障类", "综合服务类", "总计"};
        Integer[] number = new Integer[]{27, 4, 2, 245, 6, 33, 25, 44, 4, 2, 2, 2, 4, 1, 1, 1, 2, 8, 413};

        List<ParamVO> data = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            ParamVO paramVO = new ParamVO();
            paramVO.setName(str[i]);
            paramVO.setValue(number[i]);
            data.add(paramVO);
        }

        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }

    @Test
    public void test3() {
        String[] str = new String[]{"公安政法类", "公用事业类", "供水报修类", "建设交通类", "经济综合类", "科教文卫类", "其他类", "社会管理类", "社会噪声类", "市容市貌类", "卫生信息类", "物业安保类", "物业服务管理类", "物业相关执法类", "消防管理类", "噪音污染类", "住房保障类", "综合服务类", "总计"};
        Integer[] number = new Integer[]{27, 4, 2, 245, 6, 33, 25, 44, 4, 2, 2, 2, 4, 1, 1, 1, 2, 8, 413};

        List<ParamVO> data = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            ParamVO paramVO = new ParamVO();
            paramVO.setName(str[i]);
            paramVO.setValue(number[i]);
            data.add(paramVO);
        }

        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }

    @Test
    public void test4() {
        String[] str = new String[]{"城管中队", "城运中心", "发展办", "服务办", "管理办", "派出所", "平安办", "市监所", "事务中心", "自治办", "总计"};
        Integer[] number = new Integer[]{30, 154, 5, 11, 82, 18, 11, 16, 9, 9, 345};


        List<ParamVO> data = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            ParamVO paramVO = new ParamVO();
            paramVO.setName(str[i]);
            paramVO.setValue(number[i]);
            data.add(paramVO);
        }

        System.out.println("data4:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }

    @Test
    public void test5() {
        String[] str = new String[]{"城管中队", "城运中心", "发展办", "服务办", "管理办", "派出所", "平安办", "市监所", "事务中心", "自治办", "总计"};
        Integer[] number = new Integer[]{30, 154, 5, 11, 82, 18, 11, 16, 9, 9, 345};

        List<ParamVO> data = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            ParamVO paramVO = new ParamVO();
            paramVO.setName(str[i]);
            paramVO.setValue(number[i]);
            data.add(paramVO);
        }

        System.out.println("data4:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }

    @Test
    public void test6() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("宝山路499弄", 7);
        data.add(paramVO);
        paramVO = new ParamVO("新华德", 2);
        data.add(paramVO);
        paramVO = new ParamVO("三宝", 8);
        data.add(paramVO);
        paramVO = new ParamVO("新宝通", 3);
        data.add(paramVO);
        paramVO = new ParamVO("芷江中路294弄", 3);
        data.add(paramVO);
        paramVO = new ParamVO("宝华里", 1);
        data.add(paramVO);
        paramVO = new ParamVO("陆丰", 2);
        data.add(paramVO);
        paramVO = new ParamVO("象山里", 4);
        data.add(paramVO);
        paramVO = new ParamVO("王家宅", 2);
        data.add(paramVO);
        paramVO = new ParamVO("新汉兴", 11);
        data.add(paramVO);
        paramVO = new ParamVO("通源", 4);
        data.add(paramVO);
        paramVO = new ParamVO("宝昌路600弄", 6);
        data.add(paramVO);
        paramVO = new ParamVO("儒林里", 5);
        data.add(paramVO);
        paramVO = new ParamVO("通阁新村", 3);
        data.add(paramVO);
        paramVO = new ParamVO("会铁", 2);
        data.add(paramVO);
        paramVO = new ParamVO("青云路435弄", 1);
        data.add(paramVO);
        paramVO = new ParamVO("止园新村", 2);
        data.add(paramVO);
        paramVO = new ParamVO("存仁里", 1);
        data.add(paramVO);

        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }

    @Test
    public void test7() {
//        202101,166,0
//        202102,92,-0.445783133
//        202103,140,0.52173913
//        202104,15,-0.892857143

    }

    @Test
    public void test8() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("公安政法类", 27);
        data.add(paramVO);
        paramVO = new ParamVO("公用事业类", 4);
        data.add(paramVO);
        paramVO = new ParamVO("供水报修类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("建设交通类", 245);
        data.add(paramVO);
        paramVO = new ParamVO("经济综合类", 6);
        data.add(paramVO);
        paramVO = new ParamVO("科教文卫类", 33);
        data.add(paramVO);
        paramVO = new ParamVO("其他类", 25);
        data.add(paramVO);
        paramVO = new ParamVO("社会管理类", 44);
        data.add(paramVO);
        paramVO = new ParamVO("社会噪声类", 4);
        data.add(paramVO);
        paramVO = new ParamVO("市容市貌类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("卫生信息类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("物业安保类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("物业服务管理类", 4);
        data.add(paramVO);
        paramVO = new ParamVO("物业相关执法类", 1);
        data.add(paramVO);
        paramVO = new ParamVO("消防管理类", 1);
        data.add(paramVO);
        paramVO = new ParamVO("噪音污染类", 1);
        data.add(paramVO);
        paramVO = new ParamVO("住房保障类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("综合服务类", 8);
        data.add(paramVO);
        paramVO = new ParamVO("总计", 413);
        data.add(paramVO);


        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }

    @Test
    public void test9() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("类别", 202103);
        data.add(paramVO);
        paramVO = new ParamVO("公安政法类", 17);
        data.add(paramVO);
        paramVO = new ParamVO("公用事业类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("供水报修类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("建设交通类", 76);
        data.add(paramVO);
        paramVO = new ParamVO("经济综合类", 4);
        data.add(paramVO);
        paramVO = new ParamVO("科教文卫类", 9);
        data.add(paramVO);
        paramVO = new ParamVO("其他类", 7);
        data.add(paramVO);
        paramVO = new ParamVO("社会管理类", 17);
        data.add(paramVO);
        paramVO = new ParamVO("社会噪声类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("市容市貌类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("卫生信息类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("物业安保类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("物业服务管理类", 2);
        data.add(paramVO);
        paramVO = new ParamVO("物业相关执法类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("消防管理类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("噪音污染类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("住房保障类", 0);
        data.add(paramVO);
        paramVO = new ParamVO("综合服务类", 4);
        data.add(paramVO);
        paramVO = new ParamVO("总计", 140);
        data.add(paramVO);

        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }

    @Test
    public void test10() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("城管中队", 30);
        data.add(paramVO);
        paramVO = new ParamVO("城运中心", 154);
        data.add(paramVO);
        paramVO = new ParamVO("发展办", 5);
        data.add(paramVO);
        paramVO = new ParamVO("服务办", 11);
        data.add(paramVO);
        paramVO = new ParamVO("管理办", 82);
        data.add(paramVO);
        paramVO = new ParamVO("派出所", 18);
        data.add(paramVO);
        paramVO = new ParamVO("平安办", 11);
        data.add(paramVO);
        paramVO = new ParamVO("市监所", 16);
        data.add(paramVO);
        paramVO = new ParamVO("事务中心", 9);
        data.add(paramVO);
        paramVO = new ParamVO("自治办", 9);
        data.add(paramVO);

        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
    }


    @Test
    public void test11() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();

        paramVO = new ParamVO("宝昌路600弄", 6);data.add(paramVO);
        paramVO = new ParamVO("宝华里", 1);
        data.add(paramVO);
        paramVO = new ParamVO("宝山路499弄", 7);
        data.add(paramVO);
        paramVO = new ParamVO("存仁里", 1);
        data.add(paramVO);
        paramVO = new ParamVO("会铁", 2);
        data.add(paramVO);
        paramVO = new ParamVO("陆丰", 2);
        data.add(paramVO);
        paramVO = new ParamVO("青云路435弄", 1);
        data.add(paramVO);
        paramVO = new ParamVO("儒林里", 5);
        data.add(paramVO);
        paramVO = new ParamVO("三宝", 8);
        data.add(paramVO);
        paramVO = new ParamVO("通阁新村", 3);
        data.add(paramVO);
        paramVO = new ParamVO("通源", 4);
        data.add(paramVO);
        paramVO = new ParamVO("王家宅", 2);
        data.add(paramVO);
        paramVO = new ParamVO("象山里", 4);
        data.add(paramVO);
        paramVO = new ParamVO("新宝通", 3);
        data.add(paramVO);
        paramVO = new ParamVO("新汉兴", 11);
        data.add(paramVO);
        paramVO = new ParamVO("新华德", 2);
        data.add(paramVO);
        paramVO = new ParamVO("止园新村", 2);
        data.add(paramVO);
        paramVO = new ParamVO("芷江中路294弄", 3);
        data.add(paramVO);

        System.out.println("---居委会案件数 当年的数据--start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---居委会案件数-----------end");
    }


    @Test
    public void test12() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("宝昌路600弄", 3);data.add(paramVO);
        paramVO = new ParamVO("宝华里", 0);data.add(paramVO);
        paramVO = new ParamVO("宝山路499弄", 2);data.add(paramVO);
        paramVO = new ParamVO("存仁里", 1);data.add(paramVO);
        paramVO = new ParamVO("会铁", 1);data.add(paramVO);
        paramVO = new ParamVO("陆丰", 1);data.add(paramVO);
        paramVO = new ParamVO("青云路435弄", 0);data.add(paramVO);
        paramVO = new ParamVO("儒林里", 1);data.add(paramVO);
        paramVO = new ParamVO("三宝", 3);data.add(paramVO);
        paramVO = new ParamVO("通阁新村", 1);data.add(paramVO);
        paramVO = new ParamVO("通源", 1);data.add(paramVO);
        paramVO = new ParamVO("王家宅", 0);data.add(paramVO);
        paramVO = new ParamVO("象山里", 2);data.add(paramVO);
        paramVO = new ParamVO("新宝通", 1);data.add(paramVO);
        paramVO = new ParamVO("新汉兴", 2);data.add(paramVO);
        paramVO = new ParamVO("新华德", 0);data.add(paramVO);
        paramVO = new ParamVO("止园新村", 2);data.add(paramVO);
        paramVO = new ParamVO("芷江中路294弄", 1);data.add(paramVO);

        System.out.println("--行标签,202103 3月的数据---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--------------------------end");
    }

    @Test
    public void test13(){
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("青云路435弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新华德",4.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("王家宅",4.50);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",5.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里",6.50);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里",6.75);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",7.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",8.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",8.50);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝昌路600弄",8.75);data.add(paramVO);

        System.out.println("--处理时间 红榜-------------start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--------------------------end");
    }

    @Test
    public void test14() {
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();

        paramVO = new ParamDoubleVO("宝华里",20.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",16.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",15.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",14.86);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",14.69);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",13.74);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",13.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",12.88);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",12.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",11.75);data.add(paramVO);

        System.out.println("--处理时间 黑榜---");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("-----");

    }

    @Test
    public void test15() {
        //解决率 需倒序排序 正（前10）、倒（前10）
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("宝昌路600弄",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝华里",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.29);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.84);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",0.75);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.2);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.58);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",0.73);data.add(paramVO);
        paramVO = new ParamDoubleVO("青云路435弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.83);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",0.92);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.38);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",0.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("王家宅",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",0.9);data.add(paramVO);
        paramVO = new ParamDoubleVO("新华德",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.75);data.add(paramVO);

        System.out.println("--解决率 需倒序排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--解决率 需倒序排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test16() {
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        //满意率 需倒序排序 正（前10）、倒（前10）
        paramVO = new ParamDoubleVO("宝昌路600弄",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝华里",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.14);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.6);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.4);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.2);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.28);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",0.11);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",0.64);data.add(paramVO);
        paramVO = new ParamDoubleVO("青云路435弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",0.54);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.38);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",0.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("王家宅",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",0.7);data.add(paramVO);
        paramVO = new ParamDoubleVO("新华德",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",0.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.25);data.add(paramVO);

        System.out.println("--满意率 需倒序排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--满意率 需倒序排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test17() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //工单数 需倒序排序 正（前10）、倒（前10）
        paramVO = new ParamVO("城运中心",154);data.add(paramVO);
        paramVO = new ParamVO("管理办",82);data.add(paramVO);
        paramVO = new ParamVO("城管中队",30);data.add(paramVO);
        paramVO = new ParamVO("派出所",18);data.add(paramVO);
        paramVO = new ParamVO("市监所",16);data.add(paramVO);
        paramVO = new ParamVO("新汉兴",11);data.add(paramVO);
        paramVO = new ParamVO("平安办",11);data.add(paramVO);
        paramVO = new ParamVO("服务办",11);data.add(paramVO);
        paramVO = new ParamVO("自治办",9);data.add(paramVO);
        paramVO = new ParamVO("事务中心",9);data.add(paramVO);
        paramVO = new ParamVO("三宝",8);data.add(paramVO);
        paramVO = new ParamVO("宝山路499弄",7);data.add(paramVO);
        paramVO = new ParamVO("宝昌路600弄",6);data.add(paramVO);
        paramVO = new ParamVO("儒林里",5);data.add(paramVO);
        paramVO = new ParamVO("发展办",5);data.add(paramVO);
        paramVO = new ParamVO("象山里",4);data.add(paramVO);
        paramVO = new ParamVO("通源",4);data.add(paramVO);
        paramVO = new ParamVO("芷江中路294弄",3);data.add(paramVO);
        paramVO = new ParamVO("新宝通",3);data.add(paramVO);
        paramVO = new ParamVO("通阁新村",3);data.add(paramVO);
        paramVO = new ParamVO("止园新村",2);data.add(paramVO);
        paramVO = new ParamVO("新华德",2);data.add(paramVO);
        paramVO = new ParamVO("王家宅",2);data.add(paramVO);
        paramVO = new ParamVO("陆丰",2);data.add(paramVO);
        paramVO = new ParamVO("会铁",2);data.add(paramVO);
        paramVO = new ParamVO("青云路435弄",1);data.add(paramVO);
        paramVO = new ParamVO("存仁里",1);data.add(paramVO);
        paramVO = new ParamVO("宝华里",1);data.add(paramVO);

        System.out.println("--工单数 需倒序排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--工单数 需倒序排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test18() {
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        //不属实率 需正序排序 正（前10）、倒（前10）
        paramVO = new ParamDoubleVO("宝昌路600弄",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝华里",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.71);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.16);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.45);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",0.25);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.8);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",0.27);data.add(paramVO);
        paramVO = new ParamDoubleVO("青云路435弄",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.17);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",0.08);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.63);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("王家宅",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",0.1);data.add(paramVO);
        paramVO = new ParamDoubleVO("新华德",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.25);data.add(paramVO);


        System.out.println("--不属实率 需正序排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--不属实率 需正序排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }


    @Test
    public void test19() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //物业投诉量
        paramVO = new ParamVO("宝通物业",7);data.add(paramVO);
        paramVO = new ParamVO("锋玖物业",1);data.add(paramVO);
        paramVO = new ParamVO("复欣物业",5);data.add(paramVO);
        paramVO = new ParamVO("高地物业",1);data.add(paramVO);
        paramVO = new ParamVO("静安置业",1);data.add(paramVO);
        paramVO = new ParamVO("天羽物业",1);data.add(paramVO);
        paramVO = new ParamVO("万科物业",1);data.add(paramVO);
        paramVO = new ParamVO("新湖物业",1);data.add(paramVO);

        System.out.println("--物业投诉量 当年--start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--物业投诉量 当年--end");

    }

    @Test
    public void test20() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //202103
        //物业投诉量
        paramVO = new ParamVO("宝通物业",1);data.add(paramVO);
        paramVO = new ParamVO("复欣物业",1);data.add(paramVO);
        paramVO = new ParamVO("静安置业",1);data.add(paramVO);

        System.out.println("--物业投诉量 当月--start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--物业投诉量 当月--end");

    }

    @Test
    public void test21() {
//        处理时间分布 总体 当年
//        1-5天,143
//        6-25天,270
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //202103
        //物业投诉量
        paramVO = new ParamVO("1-5天",143);data.add(paramVO);
        paramVO = new ParamVO("6-25天",270);data.add(paramVO);
        System.out.println("--处理时间分布 总体 当年--start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--处理时间分布 总体 当年--end");

    }

    @Test
    public void test22() {
//        处理时间分布 总体 202103
//        1-5天,62
//        6-25天,78
//        总计,140

        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //202103
        //物业投诉量
        paramVO = new ParamVO("1-5天",62);data.add(paramVO);
        paramVO = new ParamVO("6-25天",78);data.add(paramVO);
        System.out.println("--处理时间分布 总体 202103--start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--处理时间分布 总体 202103--end");
    }

    @Test
    public void test23_unwork() {
        List<Param3VO> data = new ArrayList<>();
        Param3VO param3VO = new Param3VO();
        //处理时间分布 主责部门 当年
        //行标签,1-5天,6-25天

//        paramIn="宝昌路600弄"
//        data:[{value:4,name:"1-5天"},{value:2,name:"6-25天"}]
        System.out.println("---宝昌路600弄---");
        param3VO = new Param3VO("宝昌路600弄", "1-5天", 4);
        data.add(param3VO);
        param3VO = new Param3VO("宝昌路600弄", "6-25天", 2);
        data.add(param3VO);
        System.out.println("data:" + gson.toJson(data));

//        {"宝昌路600弄", 4, 2},
//        {"宝华里", "0", "1"},
//        {"宝山路499弄", 0, 7},
//        {"城管中队", 5, 25},
//        {"城运中心", 56, 98},
//        {"存仁里", 1, 0},
//        {"发展办", 3, 2},
//        {"服务办", 4, 7},
//        {"管理办", 18, 64},
//        {"会铁", 1, 1},
//        {"陆丰", 1, 1},
//        {"派出所", 9, 9},
//        {"平安办", 4, 7},
//        {"青云路435弄", 1, 0},
//        {"儒林里", 3, 2},
//        {"三宝", 4, 4},
//        {"市监所", 4, 12},
//        {"事务中心", 5, 4},
//        {"通阁新村", 1, 2},
//        {"通源", 2, 2},
//        {"王家宅", 1, 1},
//        {"象山里", 3, 1},
//        {"新宝通", 1, 2},
//        {"新汉兴", 2, 9},
//        {"新华德", 1, 1},
//        {"止园新村", 1, 1},
//        {"芷江中路294弄", 2, 1},
//        {"自治办", 6, 3}
    }

    @Test
    public void test24_work() {
        //处理时间分布 主责部门 202103
//        行标签,1-5天,6-25天
//        宝昌路600弄,2,1
//        宝山路499弄,0,2
//        城管中队,4,9
//        城运中心,22,23
//        存仁里,1,0
//        发展办,3,1
//        服务办,2,4
//        管理办,5,20
//        会铁,0,1
//        陆丰,0,1
//        派出所,3,4
//        平安办,2,1
//        儒林里,1,0
//        三宝,2,1
//        市监所,3,3
//        事务中心,1,2
//        通阁新村,0,1
//        通源,1,0
//        象山里,2,0
//        新宝通,1,0
//        新汉兴,1,1
//        止园新村,1,1
//        芷江中路294弄,1,0
//        自治办,4,2
    }

    @Test
    public void test25() {
//        当年 居委会 百户案件数
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        //不属实率 需正序排序 正（前10）、倒（前10）
        paramVO = new ParamDoubleVO("宝昌路600弄",1.64);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝华里",0.4);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.96);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",0.63);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",1.98);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",1.79);data.add(paramVO);
        paramVO = new ParamDoubleVO("青云路435弄",0.7);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里",3.27);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.76);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.62);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",2.14);data.add(paramVO);
        paramVO = new ParamDoubleVO("王家宅",2.08);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里",5.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",1.15);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",5.61);data.add(paramVO);
        paramVO = new ParamDoubleVO("新华德",0.31);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",0.11);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",3.41);data.add(paramVO);

        System.out.println("--当年 居委会 百户案件数 当年---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--当年 居委会 百户案件数 当年----end");
    }

    @Test
    public void test26() {
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        //202103 居委会 百户案件数
        paramVO = new ParamDoubleVO("宝昌路600弄,0.82",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄,0.27",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里,0.63",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁,0.99",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰,0.89",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里,0.65",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝,0.28",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村,0.21",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源,0.53",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里,2.5",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通,0.38",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴,1.02",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村,0.11",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄,1.14",3.41);data.add(paramVO);

        System.out.println("--居委会 百户案件数 202103---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--居委会 百户案件数 202103----end");
    }


    @Test
    public void test27() {
        //当年 物业 百户案件数
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("宝通物业",12.78);data.add(paramVO);
        paramVO = new ParamDoubleVO("德律风物业",1.39);data.add(paramVO);
        paramVO = new ParamDoubleVO("锋玖物业",3.14);data.add(paramVO);
        paramVO = new ParamDoubleVO("复欣物业",6.05);data.add(paramVO);
        paramVO = new ParamDoubleVO("高地物业",0.49);data.add(paramVO);
        paramVO = new ParamDoubleVO("静安置业",1.92);data.add(paramVO);
        paramVO = new ParamDoubleVO("凯源物业",6.25);data.add(paramVO);
        paramVO = new ParamDoubleVO("绿岛物业",0.89);data.add(paramVO);
        paramVO = new ParamDoubleVO("瑞福物业",1.87);data.add(paramVO);
        paramVO = new ParamDoubleVO("上置物业",0.51);data.add(paramVO);
        paramVO = new ParamDoubleVO("天羽物业",2.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("万科物业",1.42);data.add(paramVO);
        paramVO = new ParamDoubleVO("新翠生物业",6.82);data.add(paramVO);
        paramVO = new ParamDoubleVO("新湖物业",1.93);data.add(paramVO);
        paramVO = new ParamDoubleVO("韵嘉物业",5.23);data.add(paramVO);

        System.out.println("--当年 物业 百户案件数---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--当年 物业 百户案件数----end");
    }


    @Test
    public void test28() {
        //202103 物业 百户案件数
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("宝通物业",4.78);data.add(paramVO);
        paramVO = new ParamDoubleVO("复欣物业",1.94);data.add(paramVO);
        paramVO = new ParamDoubleVO("高地物业",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("静安置业",0.82);data.add(paramVO);
        paramVO = new ParamDoubleVO("凯源物业",3.57);data.add(paramVO);
        paramVO = new ParamDoubleVO("瑞福物业",0.93);data.add(paramVO);
        paramVO = new ParamDoubleVO("上置物业",0.26);data.add(paramVO);
        paramVO = new ParamDoubleVO("万科物业",0.13);data.add(paramVO);
        paramVO = new ParamDoubleVO("新翠生物业",3.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("新湖物业",0.55);data.add(paramVO);
        paramVO = new ParamDoubleVO("韵嘉物业",1.31);data.add(paramVO);

        System.out.println("--202103 物业 百户案件数---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--202103 物业 百户案件数----end");
    }

    @Test
    public void test29() {
        //202103 案件类型 趋势分析
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("公安政法类",17);data.add(paramVO);
        paramVO = new ParamVO("建设交通类",76);data.add(paramVO);
        paramVO = new ParamVO("经济综合类",4);data.add(paramVO);
        paramVO = new ParamVO("科教文卫类",9);data.add(paramVO);
        paramVO = new ParamVO("其他类",7);data.add(paramVO);
        paramVO = new ParamVO("社会管理类",17);data.add(paramVO);
        paramVO = new ParamVO("社会噪声类",2);data.add(paramVO);
        paramVO = new ParamVO("市容市貌类",2);data.add(paramVO);
        paramVO = new ParamVO("物业服务管理类",2);data.add(paramVO);
        paramVO = new ParamVO("综合服务类",4);data.add(paramVO);

        System.out.println("--202103 案件类型 趋势分析---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--202103 案件类型 趋势分析----end");
    }

    @Test
    public void test30() {
        //202103 业务类型 总体概览
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("求助类",46);data.add(paramVO);
        paramVO = new ParamVO("投诉类",80);data.add(paramVO);
        paramVO = new ParamVO("意见建议类",4);data.add(paramVO);
        paramVO = new ParamVO("咨询类",10);data.add(paramVO);

        System.out.println("--202103 业务类型 总体概览---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--202103 业务类型 总体概览---end");
    }

    @Test
    public void test31() {
//        202103 联系情况 总体概览
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("无电话",30);data.add(paramVO);
        paramVO = new ParamVO("已联",110);data.add(paramVO);

        System.out.println("--202103 联系情况 总体概览---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--202103 联系情况 总体概览---end");
    }

    @Test
    public void test32() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //202103 案件类型 总体概览
        paramVO = new ParamVO("公安政法类",17);data.add(paramVO);
        paramVO = new ParamVO("建设交通类",76);data.add(paramVO);
        paramVO = new ParamVO("经济综合类",4);data.add(paramVO);
        paramVO = new ParamVO("科教文卫类",9);data.add(paramVO);
        paramVO = new ParamVO("其他类",7);data.add(paramVO);
        paramVO = new ParamVO("社会管理类",17);data.add(paramVO);
        paramVO = new ParamVO("社会噪声类",2);data.add(paramVO);
        paramVO = new ParamVO("市容市貌类",2);data.add(paramVO);
        paramVO = new ParamVO("物业服务管理类",2);data.add(paramVO);
        paramVO = new ParamVO("综合服务类",4);data.add(paramVO);

        System.out.println("--202103 案件类型 总体概览---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--202103 案件类型 总体概览---end");
    }

    @Test
    public void test33() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //202103 主责部门-居委会 总体概览
        paramVO = new ParamVO("宝昌路600弄",3);data.add(paramVO);
        paramVO = new ParamVO("宝山路499弄",2);data.add(paramVO);
        paramVO = new ParamVO("城管中队",13);data.add(paramVO);
        paramVO = new ParamVO("城运中心",45);data.add(paramVO);
        paramVO = new ParamVO("存仁里",1);data.add(paramVO);
        paramVO = new ParamVO("发展办",4);data.add(paramVO);
        paramVO = new ParamVO("服务办",6);data.add(paramVO);
        paramVO = new ParamVO("管理办",25);data.add(paramVO);
        paramVO = new ParamVO("会铁",1);data.add(paramVO);
        paramVO = new ParamVO("陆丰",1);data.add(paramVO);
        paramVO = new ParamVO("派出所",7);data.add(paramVO);
        paramVO = new ParamVO("平安办",3);data.add(paramVO);
        paramVO = new ParamVO("儒林里",1);data.add(paramVO);
        paramVO = new ParamVO("三宝",3);data.add(paramVO);
        paramVO = new ParamVO("市监所",6);data.add(paramVO);
        paramVO = new ParamVO("事务中心",3);data.add(paramVO);
        paramVO = new ParamVO("通阁新村",1);data.add(paramVO);
        paramVO = new ParamVO("通源",1);data.add(paramVO);
        paramVO = new ParamVO("象山里",2);data.add(paramVO);
        paramVO = new ParamVO("新宝通",1);data.add(paramVO);
        paramVO = new ParamVO("新汉兴",2);data.add(paramVO);
        paramVO = new ParamVO("止园新村",2);data.add(paramVO);
        paramVO = new ParamVO("芷江中路294弄",1);data.add(paramVO);
        paramVO = new ParamVO("自治办",6);data.add(paramVO);

        System.out.println("--202103 主责部门-居委会 总体概览---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--202103 主责部门-居委会 总体概览---end");
    }


    @Test
    public void test34() {
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        //202103 主责部门-各部门 总体概览

        paramVO = new ParamVO("城管中队",13);data.add(paramVO);
        paramVO = new ParamVO("城运中心",45);data.add(paramVO);
        paramVO = new ParamVO("发展办",4);data.add(paramVO);
        paramVO = new ParamVO("服务办",6);data.add(paramVO);
        paramVO = new ParamVO("管理办",25);data.add(paramVO);
        paramVO = new ParamVO("派出所",7);data.add(paramVO);
        paramVO = new ParamVO("平安办",3);data.add(paramVO);
        paramVO = new ParamVO("市监所",6);data.add(paramVO);
        paramVO = new ParamVO("事务中心",3);data.add(paramVO);
        paramVO = new ParamVO("自治办",6);data.add(paramVO);

        System.out.println("--202103 主责部门-各部门 总体概览---start");
        System.out.println("data:" + gson.toJson(data)
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("--202103 主责部门-各部门 总体概览---end");
    }


    @Test
    public void test35() {
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        //202103 处理时间 红黑榜 需排序（倒序）
        paramVO = new ParamDoubleVO("宝昌路600弄",14.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",14.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",13.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",10.91);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",5.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",5.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",11.6);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",14.22);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",20.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",18.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",13.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",6.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",16.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",15.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",10.50);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",16.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",17.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",16.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",13.50);data.add(paramVO);

        System.out.println("--202103 处理时间 红黑榜 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--202103 处理时间 红黑榜 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test36() {
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        //202103 满意率 红黑榜 需排序（倒序）

        paramVO = new ParamDoubleVO("宝昌路600弄",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.78);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",0.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.4);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.32);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.00);data.add(paramVO);

        System.out.println("--202103 满意率 红黑榜 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--202103 满意率 红黑榜 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test37() {
        //202103 工单数 红黑榜 需排序（倒序）
        List<ParamVO> data = new ArrayList<>();
        ParamVO paramVO = new ParamVO();
        paramVO = new ParamVO("宝昌路600弄",3);data.add(paramVO);
        paramVO = new ParamVO("宝山路499弄",2);data.add(paramVO);
        paramVO = new ParamVO("城管中队",13);data.add(paramVO);
        paramVO = new ParamVO("城运中心",45);data.add(paramVO);
        paramVO = new ParamVO("存仁里",1);data.add(paramVO);
        paramVO = new ParamVO("发展办",4);data.add(paramVO);
        paramVO = new ParamVO("服务办",6);data.add(paramVO);
        paramVO = new ParamVO("管理办",25);data.add(paramVO);
        paramVO = new ParamVO("会铁",1);data.add(paramVO);
        paramVO = new ParamVO("陆丰",1);data.add(paramVO);
        paramVO = new ParamVO("派出所",7);data.add(paramVO);
        paramVO = new ParamVO("平安办",3);data.add(paramVO);
        paramVO = new ParamVO("儒林里",1);data.add(paramVO);
        paramVO = new ParamVO("三宝",3);data.add(paramVO);
        paramVO = new ParamVO("市监所",6);data.add(paramVO);
        paramVO = new ParamVO("事务中心",3);data.add(paramVO);
        paramVO = new ParamVO("通阁新村",1);data.add(paramVO);
        paramVO = new ParamVO("通源",1);data.add(paramVO);
        paramVO = new ParamVO("象山里",2);data.add(paramVO);
        paramVO = new ParamVO("新宝通",1);data.add(paramVO);
        paramVO = new ParamVO("新汉兴",2);data.add(paramVO);
        paramVO = new ParamVO("止园新村",2);data.add(paramVO);
        paramVO = new ParamVO("芷江中路294弄",1);data.add(paramVO);
        paramVO = new ParamVO("自治办",6);data.add(paramVO);

        System.out.println("--202103 工单数 红黑榜 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--202103 工单数 红黑榜 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test38() {
        //202103 解决率 红黑榜 需排序（倒序）
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("宝昌路600弄",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.89);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.53);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.4);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.59);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.5);data.add(paramVO);

        System.out.println("--202103 解决率 红黑榜 需排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--202103 解决率 红黑榜 需排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test39() {
        //202103 不属实率 红黑榜 需排序（正序）
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("宝昌路600弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.11);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.44);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.6);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.41);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.5);data.add(paramVO);

        System.out.println("--202103 不属实率 红黑榜 需排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--202103 不属实率 红黑榜 需排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test40() {
        //当年 不属实率 红黑榜 需排序（正序）
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("宝昌路600弄",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝华里",1.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.71);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.13);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.4);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",0.2);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.73);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.38);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",0.27);data.add(paramVO);
        paramVO = new ParamDoubleVO("青云路435弄",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里",0.4);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.13);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",0.06);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.56);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.67);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",0.25);data.add(paramVO);
        paramVO = new ParamDoubleVO("王家宅",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",0.09);data.add(paramVO);
        paramVO = new ParamDoubleVO("新华德",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",0.0);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.11);data.add(paramVO);

        System.out.println("--当年 不属实率 红黑榜 需排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--当年 不属实率 红黑榜 需排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }

    @Test
    public void test41() {
        //当年 解决率 红黑榜 需排序（倒序）
        List<ParamDoubleVO> data = new ArrayList<>();
        ParamDoubleVO paramVO = new ParamDoubleVO();
        paramVO = new ParamDoubleVO("宝昌路600弄",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝华里",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("宝山路499弄",0.29);data.add(paramVO);
        paramVO = new ParamDoubleVO("城管中队",0.7);data.add(paramVO);
        paramVO = new ParamDoubleVO("城运中心",0.44);data.add(paramVO);
        paramVO = new ParamDoubleVO("存仁里",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("发展办",0.6);data.add(paramVO);
        paramVO = new ParamDoubleVO("服务办",0.18);data.add(paramVO);
        paramVO = new ParamDoubleVO("管理办",0.54);data.add(paramVO);
        paramVO = new ParamDoubleVO("会铁",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("陆丰",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("派出所",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("平安办",0.73);data.add(paramVO);
        paramVO = new ParamDoubleVO("青云路435弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("儒林里",0.4);data.add(paramVO);
        paramVO = new ParamDoubleVO("三宝",0.63);data.add(paramVO);
        paramVO = new ParamDoubleVO("市监所",0.75);data.add(paramVO);
        paramVO = new ParamDoubleVO("事务中心",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("通阁新村",0.33);data.add(paramVO);
        paramVO = new ParamDoubleVO("通源",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("王家宅",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("象山里",0.5);data.add(paramVO);
        paramVO = new ParamDoubleVO("新宝通",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("新汉兴",0.82);data.add(paramVO);
        paramVO = new ParamDoubleVO("新华德",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("止园新村",0.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("芷江中路294弄",1.00);data.add(paramVO);
        paramVO = new ParamDoubleVO("自治办",0.33);data.add(paramVO);

        System.out.println("--当年 解决率 红黑榜 需排序 正---start");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue)).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));

        System.out.println("--当年 解决率 红黑榜 需排序 倒---");
        System.out.println("data:" + gson.toJson(data.stream().sorted(Comparator.comparing(ParamDoubleVO::getValue).reversed()).collect(Collectors.toList()))
                .replace("\"value\"", "value")
                .replace("\"name\"", "name"));
        System.out.println("---------------------end");
    }
}