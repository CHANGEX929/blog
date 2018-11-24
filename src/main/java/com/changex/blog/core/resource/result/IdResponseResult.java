package com.changex.blog.core.resource.result;/**
 * Created by fengchu on 16/7/20 下午1:40.
 */

/**
 * @author Feng Chu
 * @date 16/7/20 下午1:40
 */
public class IdResponseResult extends ResponseResult {

    private String id;

    public IdResponseResult() {

    }

    public IdResponseResult(ResponseResult responseResult) {
        super(responseResult);
        this.id = "";
    }

    public IdResponseResult(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

