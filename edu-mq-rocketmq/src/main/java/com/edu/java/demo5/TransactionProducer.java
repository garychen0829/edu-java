package com.edu.java.demo5;

import com.alibaba.fastjson.JSONObject;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/3/13
 */
public class TransactionProducer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        TransactionMQProducer producer = new TransactionMQProducer("transaction_producer_group");
        producer.setNamesrvAddr("localhost:9876");

        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                5,
                100,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(2000),
                (Runnable r) -> {
                    Thread thread = new Thread(r);
                    thread.setName("client-transaction-msg-check-thread");
                    return thread;
                });
        producer.setExecutorService(executorService);
        producer.setTransactionListener(new TransactionListener() {
            @Override
            public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
                System.out.println("本地事务执行...");
                System.out.println("消息标签是: " + new String(msg.getTags()));
                System.out.println("消息标签是: " + new String(msg.getBody()));
                String tag = msg.getTags();
                //消息的标签,如果为true
                if (tag.equals("Transaction1")) {
                    //返回事务执行失败
                    System.out.println("模拟本地事物执行失败.");
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
                System.out.println("模拟本地事物执行成功.");
                return LocalTransactionState.COMMIT_MESSAGE;
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt msg) {
                System.out.println("服务器调用消息回查接口...");
                System.out.println("消息标签是: " + new String(msg.getTags()));
                System.out.println("消息标签是: " + new String(msg.getBody()));
                return LocalTransactionState.COMMIT_MESSAGE;
            }
        });
        producer.start();

        for (int i = 0; i < 2; i++) {
            Message msg = new Message(
                    "TopicTransaction",
                    "Transaction" + i,
                    ("Hello RocketMQ distribution transcation" + i).getBytes());
            SendResult sendResult = producer.sendMessageInTransaction(msg, null);
            System.out.println(JSONObject.toJSONString(sendResult));
            System.out.println();
            TimeUnit.MICROSECONDS.sleep(10);
        }
    }
}
