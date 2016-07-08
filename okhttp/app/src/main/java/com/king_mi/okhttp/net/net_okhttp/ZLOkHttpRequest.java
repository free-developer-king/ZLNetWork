package com.king_mi.okhttp.net.net_okhttp;

import com.alibaba.fastjson.JSON;
import com.king_mi.okhttp.net.network.ZLRequestParams;
import com.king_mi.okhttp.net.network.ZLResponse;
import com.king_mi.okhttp.net.network.ZLResposeResult;
import com.king_mi.okhttp.net.utils.LoadingProgress;
import com.king_mi.okhttp.net.utils.LogUtils;
import com.king_mi.okhttp.net.utils.ToastUtils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * okhttp的简单封装
 * Created by liuzenglong on 2016/7/7.
 */
public class ZLOkHttpRequest {
    //提交json数据
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private final OkHttpClient client = new OkHttpClient();

    private static ZLOkHttpRequest ourInstance = new ZLOkHttpRequest();

    public static ZLOkHttpRequest getInstance() {
        return ourInstance;
    }

    private ZLOkHttpRequest() {
    }


    public void doOkhttpRequest(final ZLRequestParams params) {
        //   RequestBody body = RequestBody.create(JSON, params.params.toString());


        final Request request = new Request.Builder()
                .url(params.requestUrl)
                // .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (params.showProgress) {
                    LoadingProgress.getInstance().dismiss();
                }
                params.callback.errorResponse("出现错误！");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (params.showProgress) {
                    LoadingProgress.getInstance().dismiss();
                }


                if (response.isSuccessful()) {
                    LogUtils.i("什么gui"+response.body().toString());
                } else {
                    LogUtils.i("失败");
                }
//                String result = response.body().string();        //这里只处理网络数据. 大文件，图片要用流来处理
//                final ZLResponse zlResponse = new ZLResponse();
//                final ZLResposeResult resposeResult = JSON.parseObject(result, ZLResposeResult.class);
//                zlResponse.setRequestUrl(params.requestUrl);
//                zlResponse.setResposeStr(result);
//                zlResponse.setResponseResult(resposeResult);
//                params.callback.successResponse(zlResponse);
            }
        });
    }


    /**
     * 取消请求
     * author liuzl
     * created at 2016/7/7 17:58
     **/
    public void cancelRequest(String url) {

    }
}
