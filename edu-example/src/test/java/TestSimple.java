import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TestSimple {
    List<String> codes = Arrays.asList("012","013","104","015");

    @Test
    public void test() {
        List<String> errorCodes = Arrays.asList("012","015","018");
        List<String> collect = errorCodes.stream()
                .filter(i -> Collections.frequency(codes, i) > 0).collect(Collectors.toList());

        System.out.println(collect.get(0));
        System.out.println(JSONObject.toJSONString(collect));
    }
}
