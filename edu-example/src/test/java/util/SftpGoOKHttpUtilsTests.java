package util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;

/**
 * @PackageNme: util
 * @ClassName: SftpGoOKHttpUtilsTests
 * @author: chenh
 * @date: 2021/8/11
 */
public class SftpGoOKHttpUtilsTests {

    @Test
    public void test_getToken() throws IOException {
        String url = "http://127.0.0.1:8080/api/v2/token";
        String username = "admin";
        String paswd = "sftpgo2021!";
//        String username = "hui.chen1";
//        String paswd = "Password01";
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new BasicAuthInterceptor(username, paswd))
                .addInterceptor(new LogInterceptor())
                .build();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

}
