package com.changex.blog.core.resource.result;/**
 * Created by fengchu on 16/7/27 下午12:37.
 */


/**
 * @author Feng Chu
 * @date 16/7/27 下午12:37
 */
public class DataResponseResult<T> extends ResponseResult {

    private T data;

    public DataResponseResult() {
    }

    public DataResponseResult(ResponseResult responseResult) {
        super(responseResult);
    }

    public DataResponseResult(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
