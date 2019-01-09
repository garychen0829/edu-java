package com.example;

import com.alibaba.fastjson.JSONObject;

import java.util.*;

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
        String banks = "{\n" +
                "\"ABC\":\"农业银行\",\n" +
                "\"ABC\":\"农业银行\",\n" +
                "\"AHRCU\":\"安徽省农信社\",\n" +
                "\"BCCB\":\"北京银行\",\n" +
                "\"BCCB\":\"北京银行\",\n" +
                "\"BCD\":\"成都银行\",\n" +
                "\"BCM\":\"澳门商业银行\",\n" +
                "\"BCOM\":\"交通银行\",\n" +
                "\"BCOM\":\"交通银行\",\n" +
                "\"BCQ\":\"重庆银行\",\n" +
                "\"BJRCB\":\"北京农商行\",\n" +
                "\"BNU\":\"大西洋银行\",\n" +
                "\"BOC\":\"中国银行\",\n" +
                "\"BOC\":\"中国银行\",\n" +
                "\"BOIMC\":\"内蒙古银行\",\n" +
                "\"BQD\":\"青岛银行\",\n" +
                "\"BSCB\":\"包商银行\",\n" +
                "\"CBHB\":\"渤海银行\",\n" +
                "\"CCB\":\"建设银行\",\n" +
                "\"CCB\":\"建设银行\",\n" +
                "\"CDCCB\":\"承德银行\",\n" +
                "\"CDRCB\":\"成都农商行\",\n" +
                "\"CEB\":\"光大银行\",\n" +
                "\"CEB\":\"光大银行\",\n" +
                "\"CGB\":\"平顶山银行\",\n" +
                "\"CHIYUB\":\"集友银行\",\n" +
                "\"CHONGHINGB\":\"创兴银行\",\n" +
                "\"CIB\":\"兴业银行\",\n" +
                "\"CIB\":\"兴业银行\",\n" +
                "\"CITIBANK\":\"花旗银行\",\n" +
                "\"CITIC\":\"中信银行\",\n" +
                "\"CITIC\":\"中信银行\",\n" +
                "\"CMBC\":\"民生银行\",\n" +
                "\"CMBC\":\"民生银行\",\n" +
                "\"CMB\":\"招商银行\",\n" +
                "\"CMB\":\"招商银行\",\n" +
                "\"CQRCB\":\"重庆农商行\",\n" +
                "\"CRB\":\"珠海华润银行\",\n" +
                "\"CSCCB\":\"长沙银行\",\n" +
                "\"CSRCB\":\"常熟农商行\",\n" +
                "\"CZB\":\"浙商银行\",\n" +
                "\"CZB\":\"浙商银行\",\n" +
                "\"CZCCB\":\"沧州银行\",\n" +
                "\"DAHSING\":\"大新银行\",\n" +
                "\"DDCB\":\"丹东银行\",\n" +
                "\"DLB\":\"大连银行\",\n" +
                "\"DYB\":\"东营银行\",\n" +
                "\"FJNXS\":\"福建省农信社\",\n" +
                "\"FSCB\":\"抚顺银行\",\n" +
                "\"FUDB\":\"富滇银行\",\n" +
                "\"FXCB\":\"阜新银行\",\n" +
                "\"GDB\":\"广发银行\",\n" +
                "\"GDB\":\"广发银行\",\n" +
                "\"GDNYB\":\"广东南粤银行\",\n" +
                "\"GDSDRCB\":\"顺德农商行\",\n" +
                "\"GLCCB\":\"桂林银行\",\n" +
                "\"GRCB\":\"广州农商行\",\n" +
                "\"GSSNXS\":\"甘肃省农信社\",\n" +
                "\"GXNTHCB\":\"广西北部湾银行\",\n" +
                "\"GYCCB\":\"贵阳银行\",\n" +
                "\"GZCB\":\"广州银行\",\n" +
                "\"GZCCB\":\"赣州银行\",\n" +
                "\"GZRCB\":\"广州农商行\",\n" +
                "\"HBB\":\"湖北银行\",\n" +
                "\"HBNXS\":\"湖北农信社\",\n" +
                "\"HBYH\":\"河北银行\",\n" +
                "\"HCCB\":\"杭州银行\",\n" +
                "\"HEBNXHTB\":\"哈尔滨农商行\",\n" +
                "\"HHRCB\":\"黄河农商行\",\n" +
                "\"HKBEA\":\"东亚银行\",\n" +
                "\"HKB\":\"汉口银行\",\n" +
                "\"HRBCB\":\"哈尔滨银行\",\n" +
                "\"HRXJB\":\"华融湘江银行\",\n" +
                "\"HSBC\":\"汇丰银行\",\n" +
                "\"HSB\":\"恒生银行\",\n" +
                "\"HSCB\":\"衡水银行\",\n" +
                "\"HSOB\":\"徽商银行\",\n" +
                "\"HXB\":\"华夏银行\",\n" +
                "\"HXB\":\"华夏银行\",\n" +
                "\"ICBC\":\"工商银行\",\n" +
                "\"ICBC\":\"工商银行\",\n" +
                "\"JHCB\":\"金华银行\",\n" +
                "\"JJCCB\":\"九江银行\",\n" +
                "\"JLB\":\"吉林银行\",\n" +
                "\"JNRCB\":\"江南农商行\",\n" +
                "\"JSB\":\"江苏银行\",\n" +
                "\"JSHB\":\"晋商银行\",\n" +
                "\"JSRCU\":\"江苏省农信社\",\n" +
                "\"JXB\":\"江西银行\",\n" +
                "\"JXCB\":\"嘉兴银行\",\n" +
                "\"JYRCB\":\"江阴农商行\",\n" +
                "\"JZB\":\"锦州银行\",\n" +
                "\"LHB\":\"漯河商业银行\",\n" +
                "\"LJBANK\":\"龙江银行\",\n" +
                "\"LSB\":\"莱商银行\",\n" +
                "\"LSCB\":\"临商银行\",\n" +
                "\"LUSOB\":\"澳门国际银行\",\n" +
                "\"LZCB\":\"兰州银行\",\n" +
                "\"NBCB\":\"宁波银行\",\n" +
                "\"NCBBANK\":\"南洋商业银行\"\n" +
                "}";

        Map<String, String> map = JSONObject.parseObject(banks, HashMap.class);

        List<TiedBankVO> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " >> " + entry.getValue());
            TiedBankVO tiedBankVO = new TiedBankVO();
            tiedBankVO.setBankCode(entry.getKey());
            tiedBankVO.setBankName(entry.getValue());
            tiedBankVO.setUsabled(false);
            list.add(tiedBankVO);
        }


        System.out.println(JSONObject.toJSONString(list));
    }
}
