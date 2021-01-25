package util;

import com.alibaba.fastjson.JSONObject;
import com.vo.UserVO;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @PackageNme: util
 * @ClassName: MapUtils
 * @author: chenh
 * @date: 2020/12/10
 */
public class MapUtils {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        UserVO user = new UserVO();
        user.setUserName("chenh");
        user.setAge(1);

        Map<String, String> map = MapUtils.toMap(user);
        System.out.println(map.toString());
        System.out.println(JSONObject.toJSONString(map));


    }

    public static <T> Map<String, String> toMap(T t) {
        Map<String, String> map = null;
        try {
            map = BeanUtils.describe(t);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return map;
    }

}
