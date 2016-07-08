package com.king_mi.okhttp.net.network;

import com.king_mi.okhttp.net.utils.LoadingProgress;
import com.king_mi.okhttp.net.utils.ToastUtils;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

/**
 * NoHttp的封装
 */
public class ZLNoHttpRequest {

    private static RequestQueue requestQueue;

    private static ZLNoHttpRequest ourInstance = new ZLNoHttpRequest();

    public static ZLNoHttpRequest getInstance() {
        return ourInstance;
    }

    private ZLNoHttpRequest() {
        requestQueue = NoHttp.newRequestQueue();
    }

    public void doNoHttpRequest(final ZLRequestParams requestParams) {
        Request request = NoHttp.createStringRequest(requestParams.requestUrl, requestParams.requestWay == ZLRequestParams.RequestWay.POST ? RequestMethod.POST : RequestMethod.GET);
        request.add(requestParams.params);
        request.setCancelSign(requestParams.requestUrl);
        requestQueue.add(0, request, new OnResponseListener() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, Response response) {
                LoadingProgress.getInstance().dismiss();
                String result = (String) response.get();
                ToastUtils.show(requestParams.mContext,result);
//                LogUtils.i(result);
//                final ZLResponse zlResponse = new ZLResponse();
//                final ZLResposeResult resposeResult = JSON.parseObject(result, ZLResposeResult.class);
//                zlResponse.setRequestUrl(requestParams.requestUrl);
//                zlResponse.setResposeStr(result);
//                zlResponse.setResponseResult(resposeResult);
//                requestParams.callback.successResponse(zlResponse);
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                LoadingProgress.getInstance().dismiss();
            }

            @Override
            public void onFinish(int what) {
                LoadingProgress.getInstance().dismiss();
            }
        });
    }

    /**
     * 取消请求
     * author liuzl
     * created at 2016/7/7 17:58
     **/
    public void cancelRequest(String url){
        requestQueue.cancelBySign(url);
    }
}
