import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 *
 * @author hui2.chen
 * @date 2018/10/22
 */
public class TestMain {

    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        String[] s1 = {"09:00","11:00"};
        String[] s2 = {"12:00","14:00"};
        String[] s3 = {"15:00","17:00"};
        list.add(s1);
        list.add(s2);
        list.add(s3);

        String dailyLimitSegs = JSONObject.toJSONString(list);
        System.out.println(dailyLimitSegs);

        List<String[]> lst = JSONObject.parseArray(dailyLimitSegs,String[].class);
        for (String[] strings : list) {
            System.out.println(strings[0] + ">>" + strings[1]);
        }
        System.out.println(lst.size());

    }
}
