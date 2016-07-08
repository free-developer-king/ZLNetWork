package com.king_mi.okhttp.net.network;

/**
 * 功能:服务器返回，
 * 作者: by 刘增龙 on 2016/4/11 11:59.
 * 邮箱:hg_liuzl@qq.com
 */
public class ZLResponse {

    /**
     * 请求服务器的路径
     **/
    private String requestUrl;

    /**
     * 服务器返回的结果字符串
     **/
    private String resposeStr;

    /***
     * 服务器返回的结果对象
     **/
    private ZLResposeResult responseResult;

    public ZLResposeResult getResponseResult() {
        return responseResult;
    }

    public void setResponseResult(ZLResposeResult responseResult) {
        this.responseResult = responseResult;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getResposeStr() {
        return resposeStr;
    }

    public void setResposeStr(String resposeStr) {
        this.resposeStr = resposeStr;
    }
}
