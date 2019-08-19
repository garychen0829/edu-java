package com.example.rpc.edurpc.demo1_rpc.service;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/19
 */
public class ServerMain {
    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        LocateRegistry.createRegistry(8801);
        Naming.bind("rmi://localhost:8801/helloService", helloService);
        System.out.println("ServerMain provide RPC service now.");
    }
}
