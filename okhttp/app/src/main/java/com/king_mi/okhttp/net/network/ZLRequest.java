package com.king_mi.okhttp.net.network;

import android.content.Context;

import com.king_mi.okhttp.net.net_nohttp.ZLNoHttpRequest;
import com.king_mi.okhttp.net.net_okhttp.ZLOkHttpRequest;
import com.king_mi.okhttp.net.net_volley.ZLVolleyRequest;
import com.king_mi.okhttp.net.utils.LoadingProgress;
import com.king_mi.okhttp.net.utils.ToastUtils;


/**
 * 功能:网络请求
 * 作者: by 刘增龙 on 2016/5/19 18:19.
 * 邮箱:hg_liuzl@qq.com
 */
public class ZLRequest {

    private static ZLRequest ourInstance = new ZLRequest();

    public static ZLRequest getInstance() {
        return ourInstance;
    }

    private ZLRequest() {

    }

    /**
     * 发送请求
     * author liuzl
     * created at 2016/7/7 17:54
     **/
    public void sendRequest(ZLRequestParams requestParams) {
        if (!ZLUtils.isNetworkConnected(requestParams.mContext)) {
            ToastUtils.show(requestParams.mContext, "网络未连接!");
            return;
        }
        if (requestParams.showProgress) {
            LoadingProgress.getInstance().show(requestParams.mContext);
        }
        if (ZLRequestParams.NetWorkLibType.volley == requestParams.libType) {
            ZLVolleyRequest.getInstance().doVolleyRequest(requestParams);
        } else if (ZLRequestParams.NetWorkLibType.okhttp == requestParams.libType) {
            ZLOkHttpRequest.getInstance().doOkhttpRequest(requestParams);
        } else if (ZLRequestParams.NetWorkLibType.nohttp == requestParams.libType) {
            ZLNoHttpRequest.getInstance().doNoHttpRequest(requestParams);
        } else {
            ZLVolleyRequest.getInstance().doVolleyRequest(requestParams);
        }
    }


    /**
     * 取消请求
     * author liuzl
     * created at 2016/7/7 17:49
     **/
    private void cancelRequest(ZLRequestParams requestParams) {
        if (ZLRequestParams.NetWorkLibType.volley == requestParams.libType) {
            ZLVolleyRequest.getInstance().cancelRequest(requestParams.requestUrl);
        } else if (ZLRequestParams.NetWorkLibType.okhttp == requestParams.libType) {
            ZLOkHttpRequest.getInstance().cancelRequest(requestParams.requestUrl);
        } else if (ZLRequestParams.NetWorkLibType.nohttp == requestParams.libType) {
            ZLNoHttpRequest.getInstance().cancelRequest(requestParams.requestUrl);
        } else {
            ZLVolleyRequest.getInstance().cancelRequest(requestParams.requestUrl);
        }
    }
}
