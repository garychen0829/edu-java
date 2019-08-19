package com.example.rpc.edurpc.demo1_rmi.factory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/**
 * <pre>
 * RMI 穿透防火墙
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/19
 */
public class MySocketFactory extends RMISocketFactory {
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return new Socket(host, port);
    }

    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        if (0 == port) {
            port = 8802;
        }
        System.out.println("rmi nofity port: " + port);
        return new ServerSocket(port);
    }
}
