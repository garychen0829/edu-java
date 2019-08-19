package com.example.rpc.edurpc.demo1_rpc.client;

import com.example.rpc.edurpc.demo1_rpc.service.HelloService;

import java.rmi.Naming;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/19
 */
public class ClientMain {
    public static void main(String[] args) throws Exception {
        HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8801/helloService");

        for (int i = 1; i < 9; i++) {

            System.out.println("RMI 服务调用返回结果: " + helloService.sayHello("hahahh" + i));
        }
    }
}
