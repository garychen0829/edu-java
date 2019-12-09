package com.example.rpc.edurpc.common.serializer;

/**
 * 描述:
 *
 * @author hui2.chen
 * @date 2019/11/14
 */
public interface ISerializer {

    <T> byte[] serialize(T obj);

    <T> T deserialize(byte[] bytes, Class<T> clazz);
}
