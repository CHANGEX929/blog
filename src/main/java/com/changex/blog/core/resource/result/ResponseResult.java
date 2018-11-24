package com.changex.blog.core.resource.result;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/23 23:12
 */
public class ResponseResult {
    /**
     * 接口调用情况说明
     */
    private String msg;
    /**
     * 接口是否调用成功
     */
    private boolean success;
    /**
     * 接口调用错误码
     */
    private Integer error;

    /**
     * 默认构造函数，success为true，error为200，msg为""。
     */
    public ResponseResult() {
        this.msg = "";
        this.success = true;
        this.error = ErrorCodes.SUCCESS;
    }

    /**
     * 构造函数，success为true，error为200，可以设置msg。
     *
     * @param msg
     */
    public ResponseResult(String msg) {
        this.msg = msg;
        this.success = true;
        this.error = ErrorCodes.SUCCESS;
    }

    /**
     * 构造函数，success为false，可以设置msg和error。
     *
     * @param msg
     * @param error
     */
    public ResponseResult(String msg, Integer error) {
        this.msg = msg;
        this.success = false;
        this.error = error;
    }

    /**
     * 构造函数，个参数值均可设置。
     *
     * @param msg
     * @param success
     * @param error
     */
    public ResponseResult(String msg, boolean success, Integer error) {
        this.msg = msg;
        this.success = success;
        this.error = error;
    }

    public ResponseResult(ResponseResult responseResult) {
        this.msg = responseResult.getMsg();
        this.success = responseResult.isSuccess();
        this.error = responseResult.getError();
    }

    public void setResponseResult(ResponseResult responseResult) {
        this.msg = responseResult.getMsg();
        this.success = responseResult.isSuccess();
        this.error = responseResult.getError();
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
