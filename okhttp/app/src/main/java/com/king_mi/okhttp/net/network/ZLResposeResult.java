package com.king_mi.okhttp.net.network;

/**
 * 功能:处理服务器返回的数据
 * 作者: by 刘增龙 on 2016/4/11 12:10.
 * 邮箱:hg_liuzl@qq.com
 */
public class ZLResposeResult {

    /**
     * 状态
     **/
    private String success;

    /**
     * 服务器返回码
     **/
    private String resultCode;

    /**
     * 错误信息
     **/
    private String errorMsg;

    /**
     * 响应时间
     **/
    private String time;

    /**
     * 返回对象，需要再次解析
     **/
    private String body;


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean getSuccess() {
        return "true".equalsIgnoreCase(success);
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
