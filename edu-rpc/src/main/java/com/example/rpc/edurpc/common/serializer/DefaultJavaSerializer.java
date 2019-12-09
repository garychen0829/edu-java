package com.example.rpc.edurpc.common.serializer;

import java.io.*;

/**
 * 描述:
 *
 * @author hui2.chen
 * @date 2019/11/14
 */
public class DefaultJavaSerializer implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(byteOutStream);
            outputStream.writeObject(obj);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteOutStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clazz) {
        ByteArrayInputStream byteInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream inputStream = new ObjectInputStream(byteInputStream);
            return (T) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
