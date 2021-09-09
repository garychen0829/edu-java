package com.queue.delay;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

public class DelayedService {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayedItem> delayQueue = new DelayQueue<DelayedItem>();


        List<String> list = Arrays.asList("BGW.016", "BGW.017", "BGW.018");
        if (Collections.frequency(list, "BGW.017") > 0) {
            ITestInvoke invoke = new TestInvokeImpl();
            delayQueue.put(new DelayedItem("test",invoke, 5, TimeUnit.SECONDS));
            delayQueue.put(new DelayedItem("test",invoke, 10, TimeUnit.SECONDS));

        }
        System.out.println("queue size() =>" + delayQueue.size());
        for (int i = 0; i < 2; i++) {
            DelayedItem d = delayQueue.take();

            System.out.format("name:{%s}, time:{%s}\n", d.getName(), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            System.out.println(d.getInvoke().invokeRetMap("20200415"));
        }

    }

}
