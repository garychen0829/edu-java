package com.example.rpc.edurpc.demo2_rpc.service;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/20
 */
public class RpcConsumerMain {

    public static void main(String[] args) throws InterruptedException {
        HelloService service = ConsumerProxy.consume(HelloService.class,"127.0.0.1",8803);

        for (int i = 0; i < 100; i++) {
            String str = service.sayHello("hello: " + i);
            System.out.println(str);
            Thread.sleep(1000);
        }
    }
}
