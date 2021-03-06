package com.example.rpc.edurpc.demo2_rpc;

import com.example.rpc.edurpc.demo2_rpc.client.ProviderReflect;
import com.example.rpc.edurpc.demo2_rpc.service.HelloService;
import com.example.rpc.edurpc.demo2_rpc.service.HelloServiceImpl;

import java.io.IOException;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/20
 */
public class RpcProviderMain {

    public static void main(String[] args) throws IOException {
        HelloService service = new HelloServiceImpl();
        ProviderReflect.provider(service, 8803);
        System.out.println("provider main started.");
    }
}
