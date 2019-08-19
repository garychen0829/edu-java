package com.example.rpc.edurpc.demo1_rmi.service;

import com.example.rpc.edurpc.demo1_rmi.factory.MySocketFactory;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

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
        LocateRegistry.createRegistry(8801);
        //指定通讯端口, 防止被防火墙拦截
        RMISocketFactory.setSocketFactory(new MySocketFactory());
        HelloService helloService = new HelloServiceImpl();
        Naming.bind("rmi://localhost:8801/helloService", helloService);
        System.out.println("ServerMain provide RPC service now.");
    }
}
