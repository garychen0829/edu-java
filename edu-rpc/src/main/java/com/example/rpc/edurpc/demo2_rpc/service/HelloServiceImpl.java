package com.example.rpc.edurpc.demo2_rpc.service;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/19
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String content) {
        System.out.println("say Hello :" + content);
        return "hello: " + content;
    }
}
