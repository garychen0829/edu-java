package util;

import okhttp3.Call;
import okhttp3.Response;

import java.io.IOException;

/**
 * http请求回调类,回调方法在UI线程中执行
 */
public abstract class RealCallback {
    /**
     * 请求成功回调
     *
     * @param response
     */
    public abstract void onResponse(Call call, Response response);

    /**
     * 请求失败回调
     *
     * @param e
     */
    public abstract void onFailure(Call call, IOException e);
}