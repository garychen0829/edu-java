package com.queue.delay;

import java.util.HashMap;
import java.util.Map;

public class TestInvokeImpl implements ITestInvoke {

    @Override
    public Map invokeRetMap(String txt) {
        Map<String, String> map = new HashMap<>();
        map.put("key_" + txt, txt);
        return map;
    }
}
