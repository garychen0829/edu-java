package com.queue.demo1;

import java.util.concurrent.DelayQueue;

import static com.queue.demo1.TimeUtil.timeUtil;


public class DelayQueueDemo {

    public static void main(String[] args) {
        DelayQueue<DataCache> mQueue = new DelayQueue<>();
        for (int i = 0; i < 10; i++) {
            DataCache data = new DataCache();
            //缓存的具体内容。
            data.setMsg("缓存" + i);

            //给缓存时间设置缓存失效时间。
            data.setExpireTime(System.currentTimeMillis() + (i + 2) * 2000);

            //把缓存数据加入缓存队列。
            mQueue.offer(data);
        }

        //开始延迟处理缓存数据。当失效时候就清理掉。
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (mQueue.isEmpty()) {
                        break;
                    } else {
                        DataCache data;
                        try {
                            System.out.println("当前队列长度:" + mQueue.size());

                            data = mQueue.take(); //从队列中取出一条数据。

                            System.out.println(data.getMsg() + " 失效时间:\t" + timeUtil(data.getExpireTime()));
                            System.out.println("在系统时间\t\t" + timeUtil(System.currentTimeMillis()) + " 清除缓存");
                            System.out.println("==========");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}
