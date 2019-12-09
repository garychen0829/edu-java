package com.example.rpc.edurpc.demo2_rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/19
 */
public class ConsumerProxy {

    /**
     * 服务消费代理接口
     *
     * @param interfaceClass
     * @param host
     * @param port
     * @param <T>
     * @return
     */
    public static <T> T consume(final Class<T> interfaceClass, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, (proxy, method, args) -> {
            Socket socket = null;
            ObjectOutputStream output = null;
            ObjectInputStream input = null;
            Object result = null;
            try {
                socket = new Socket(host, port);
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeUTF(method.getName());
                output.writeObject(args);

                input = new ObjectInputStream(socket.getInputStream());
                result = input.readObject();
                if (result instanceof Throwable) {
                    throw (Throwable) result;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                input.close();
                output.close();
                socket.close();
            }
            return result;
        });

//        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                Socket socket = new Socket(host, port);
//
//                try {
//
//                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
//
//                    try {
//                        output.writeUTF(method.getName());
//                        output.writeObject(args);
//
//                        ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
//                        try {
//                            Object result = input.readObject();
//                            if (result instanceof Throwable) {
//                                throw (Throwable) result;
//                            }
//                            return result;
//                        }finally {
//                            input.close();
//                        }
//                    }finally {
//                        output.close();
//                    }
//
//                }finally {
//                    socket.close();
//                }
//            }
//        });
    }
}
