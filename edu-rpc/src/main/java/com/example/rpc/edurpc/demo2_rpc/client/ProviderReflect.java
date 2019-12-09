package com.example.rpc.edurpc.demo2_rpc.client;

import org.apache.commons.lang3.reflect.MethodUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.Executors.*;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/8/20
 */
public class ProviderReflect {
    private static final ExecutorService executorService = newCachedThreadPool();

    public static void provider(final Object service, int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            final Socket socket = serverSocket.accept();
            executorService.execute(()->{
                try {
                    ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

                    String methodName = input.readUTF();

                    Object[] args = (Object[])input.readObject();

                    ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());

                    Object result = MethodUtils.invokeExactMethod(service, methodName, args);

                    output.writeObject(result);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
