package com.example.rpc.edurpc.demo1_rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/19
 */
public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {

    protected HelloServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello(String someone) throws RemoteException {
        System.out.println("sayHello inpute someone : " + someone);
        return "hello : " + someone;
    }
}
