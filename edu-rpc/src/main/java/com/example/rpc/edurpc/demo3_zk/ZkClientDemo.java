package com.example.rpc.edurpc.demo3_zk;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

/**
 * zkClient 客户端简单api操作
 *
 * @author hui2.chen
 * @date 2019/8/23
 */
public class ZkClientDemo {
    public static void main(String[] args) {
        String zkString = "127.0.0.1:2181";
        int connectTimeout = 3000;

        ZkClient zkClient = new ZkClient(zkString, connectTimeout);
        String path = "/zk-data-201908";

        //若节点已经存在,则删除
        if (zkClient.exists(path)) {
            zkClient.delete(path);
        }

        //创建节点
        zkClient.createPersistent(path);
        //写入数据
        zkClient.writeData(path, "test_data_1");
        //节点读取数据
        String data_1 = zkClient.readData(path);

        //创建节点并写入数据
//        zkClient.createPersistent(path,"test_data_2");
//        zkClient.createPersistentSequential("","");
//        zkClient.createEphemeral();
//        zkClient.createEphemeralSequential();

        System.out.println(data_1);

        /**
         * 监听节点数据变动
         */
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String path, Object data) throws Exception {
                System.out.println("data [change] path=" + path + ", data=" + data);
            }

            @Override
            public void handleDataDeleted(String path) throws Exception {
                System.out.println("data [delete] path=" + path);
            }
        });

        zkClient.writeData(path, "new_date");
        zkClient.delete(path);
        zkClient.createPersistent(path + "_1", "new_date");
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
