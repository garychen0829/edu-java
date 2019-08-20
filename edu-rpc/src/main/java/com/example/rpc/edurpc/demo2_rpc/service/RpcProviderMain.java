package com.example.rpc.edurpc.demo2_rpc.service;

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
    }
}
