package com.example.rpc.edurpc.demo1_rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/19
 */
public interface HelloService extends Remote {
    String sayHello(String someone) throws RemoteException;
}
