package com.king_mi.okhttp.net.network;


import android.content.Context;

import java.util.Map;

/**
 * 功能:网络请求类
 * 作者: by 刘增龙 on 2016/4/14 11:16.
 * 邮箱:hg_liuzl@qq.com
 */
public class ZLRequestParams {

    /***
     * 网络框架类型
     **/
    public enum NetWorkLibType {
        okhttp,
        volley,
        nohttp,
    }

    /**
     * 请求方式
     **/
    public enum RequestWay {
        POST,
        GET
    }


    /**
     * 网络请求框架类型，默认用volley
     **/
    public NetWorkLibType libType = NetWorkLibType.volley;

    /***
     * 网络请求方式,默认是post请求
     **/
    public RequestWay requestWay = RequestWay.POST;

    /**
     * 对就的Context
     **/
    public Context mContext;
    /**
     * 网络请求路径
     **/
    public String requestUrl;
    /***
     * 网络请求参数
     **/
    public Map<String, String> params;
    /**
     * 网络请求是否需要进度dialog
     ***/
    public boolean showProgress = true;
    /**
     * 网络请求的回调
     ***/
    public ZLResponseCallback callback;

    public ZLRequestParams() {
    }

    public ZLRequestParams(Context context, String requestUrl, Map<String, String> params, ZLResponseCallback callback) {
        this.mContext = context;
        this.requestUrl = requestUrl;
        this.params = params;
        this.callback = callback;
    }

    public ZLRequestParams(NetWorkLibType libType, Context context, String requestUrl, Map<String, String> params, boolean showProgress, ZLResponseCallback callback) {
        this.libType = libType;
        this.mContext = context;
        this.requestUrl = requestUrl;
        this.params = params;
        this.showProgress = showProgress;
        this.callback = callback;
    }


    public ZLRequestParams(ZLResponseCallback callback, NetWorkLibType libType, RequestWay requestWay, Context context, String requestUrl, Map<String, String> params, boolean showProgress) {
        this.callback = callback;
        this.libType = libType;
        this.requestWay = requestWay;
        this.mContext = context;
        this.requestUrl = requestUrl;
        this.params = params;
        this.showProgress = showProgress;
    }
}
