package com.edu.java.demo4.consumer;

import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/12
 */
public class OrderMessageListener implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
        String curtime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        if (null != msgs) {
            try {
                System.out.println(curtime + " > 接收到消息: ");
                Thread.sleep(new Random().nextInt(1000));


                for (MessageExt ext : msgs) {
                    try {
                        System.out.println(curtime + ">>>" + new String(ext.getBody(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }

//            msgs.stream()
//                    .forEach(m -> {
//                        try {
//                            System.out.println(curtime + ">>>" + new String(ext.getBody(), "UTF-8"));
//                        } catch (UnsupportedEncodingException e) {
//                            e.printStackTrace();
//                        }
//                    });
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}
