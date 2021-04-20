package util;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

public class OkHttpUtilsTest extends TestCase {

    /**
     * 异步
     */
    public void testPost() {
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.post("http://www.baidu.com", "{}", new RealCallback() {
            @Override
            public void onResponse(Call call, Response response) {
                String respBody = response.body().toString();
                System.out.println(respBody);
            }

            @Override
            public void onFailure(Call call, IOException e) {

            }
        });

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_sync() {
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        try {
            Response response = okHttpUtils.postSync("https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRET","{}");
            System.out.println("response=="+response.body().string());
            System.out.println(JSON.toJSONString(response));
            System.out.println(JSON.toJSONString(response.isSuccessful()));
            System.out.println(JSON.toJSONString(response.isSuccessful()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}