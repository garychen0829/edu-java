package util;

import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * <pre>
 * 描述
 * </pre>
 *
 * @author hui2.chen
 * @date 2019/9/2
 */
public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private static OkHttpClient okHttpClient;

    /**
     * 构造初始化
     */
    private OkHttpUtils() {
        /**
         * 构建OkHttpClient
         */
        okHttpClient = new OkHttpClient.Builder()
                /**
                 * 请求的超时时间
                 */
                .readTimeout(5000, TimeUnit.MILLISECONDS)
                /**
                 * 设置响应的超时时间
                 */
                .writeTimeout(5000, TimeUnit.MILLISECONDS)
                /**
                 * 设置连接的超时时间
                 */
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                /**
                 * 构建
                 */
                .build();

    }

    /**
     * 通过单例模式构造对象
     *
     * @return
     */
    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    /**
     * 构造post 请求，封装对用的Request请求，实现方法
     *
     * @param url          请求的url
     * @param requestBody  请求参数
     * @param realCallback 结果回调的方法
     */
    private void postRequest(String url, RequestBody requestBody, final RealCallback realCallback) {

        Request request = new Request.Builder().url(url).post(requestBody).build();
        deliveryResult(realCallback, okHttpClient.newCall(request));
    }


    /**
     * 处理请求结果的回调：主线程切换
     *
     * @param realCallback
     * @param call
     */
    private void deliveryResult(final RealCallback realCallback, Call call) {
        call.enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                sendFailureThread(call, e, realCallback);
            }

            @Override
            public void onResponse(final Call call, final Response response) throws IOException {
                sendSuccessThread(call, response, realCallback);
            }
        });
    }

    /**
     * 发送成功的回调
     *
     * @param call
     * @param response
     * @param realCallback
     */
    private void sendSuccessThread(final Call call, final Response response, final RealCallback realCallback) {
        realCallback.onResponse(call, response);
    }

    /**
     * 发送失败的回调
     *
     * @param call
     * @param e
     * @param realCallback
     */
    private void sendFailureThread(final Call call, final IOException e, final RealCallback realCallback) {
        realCallback.onFailure(call, e);
    }

    /**
     * post请求
     *
     * @param url          请求url
     * @param realCallback 请求回调
     * @param requestBody  请求参数
     */
    public void post(String url, RequestBody requestBody, final RealCallback realCallback) {
        postRequest(url, requestBody, realCallback);
    }
}
