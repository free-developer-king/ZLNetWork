package com.king_mi.okhttp.net.net_volley;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.king_mi.okhttp.net.network.ZLRequestParams;
import com.king_mi.okhttp.net.network.ZLResponse;
import com.king_mi.okhttp.net.network.ZLResponseCallback;
import com.king_mi.okhttp.net.network.ZLResposeResult;
import com.king_mi.okhttp.net.network.ZLUtils;
import com.king_mi.okhttp.net.utils.LoadingProgress;
import com.king_mi.okhttp.net.utils.LogUtils;
import com.king_mi.okhttp.net.utils.ToastUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 功能:$volley请求
 * 作者: by 刘增龙 on 2016/4/11 09:34.
 * 邮箱:hg_liuzl@qq.com
 */
public class ZLVolleyRequest {

    private static RequestQueue mRequestQueue;

    public static void init(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static RequestQueue getRequestQueue() {
        if (mRequestQueue != null) {
            return mRequestQueue;
        } else {
            throw new IllegalStateException("volley RequestQueue not initialized");
        }
    }


    private static ZLVolleyRequest ourInstance = new ZLVolleyRequest();

    public static ZLVolleyRequest getInstance() {
        return ourInstance;
    }

    private ZLVolleyRequest() {
    }

    public void doVolleyRequest(final ZLRequestParams params) {
        doVolleyRequest(params.mContext, params.requestUrl, params.params, params.showProgress, params.callback);
    }

    /**
     * @param mContext
     * @param url
     * @param paramKeys          请求的键，
     * @param paramValues        请求的值
     * @param showProgressDialog
     * @param callback
     */
    public void doVolleyRequest(final Context mContext, final String url, final String[] paramKeys, final String[] paramValues, final boolean showProgressDialog, final ZLResponseCallback callback) {
        Map<String, String> paramsRequest = ZLUtils.arrayToMap(paramKeys, paramValues);
        doVolleyRequest(mContext, url, paramsRequest, showProgressDialog, callback);
    }

    /**
     * @param mContext
     * @param url
     * @param paramKeys   请求的键，
     * @param paramValues 请求的值
     * @param callback
     */
    public void doVolleyRequest(final Context mContext, final String url, final String[] paramKeys, final String[] paramValues, final ZLResponseCallback callback) {
        Map<String, String> paramsRequest = ZLUtils.arrayToMap(paramKeys, paramValues);
        doVolleyRequest(mContext, url, paramsRequest, true, callback);
    }

    /**
     * @param mContext
     * @param url                请求路径
     * @param params             请求参数
     * @param showProgressDialog 是否需要打开进度条
     * @param callback
     */
    public void doVolleyRequest(final Context mContext, final String url, final Map<String, String> params, final boolean showProgressDialog, final ZLResponseCallback callback) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String result) {
                if (showProgressDialog) {
                    LoadingProgress.getInstance().dismiss();
                }
                try {
                    result = new String(result.getBytes("utf-8"));
                    ToastUtils.show(mContext, result);
//                LogUtils.i("----volley---result----------" + result);
//                ZLResposeResult resposeResult = JSON.parseObject(result, ZLResposeResult.class);
//                ZLResponse response = new ZLResponse();
//                response.setResposeStr(result);
//                response.setRequestUrl(url);
//                response.setResponseResult(resposeResult);
//                callback.successResponse(response);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (showProgressDialog) {
                    LoadingProgress.getInstance().dismiss();
                }
                ToastUtils.show(mContext, "出现错误");
                callback.errorResponse(volleyError.getMessage());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // params.putAll(ZLUtils.commonParams(mContext));
                return params;
            }
        };

        stringRequest.setTag(url);
        getRequestQueue().add(stringRequest);
    }

    /**
     * 取消请求
     * author liuzl
     * created at 2016/7/7 18:00
     **/
    public void cancelRequest(String url) {
        getRequestQueue().cancelAll(url);
    }
}
