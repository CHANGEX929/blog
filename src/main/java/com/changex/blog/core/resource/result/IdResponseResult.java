package com.changex.blog.core.resource.result;/**
 * Created by fengchu on 16/7/20 下午1:40.
 */

/**
 * @author Feng Chu
 * @date 16/7/20 下午1:40
 */
public class IdResponseResult extends ResponseResult {

    private Integer id;

    public IdResponseResult() {

    }

    public IdResponseResult(ResponseResult responseResult) {
        super(responseResult);
    }

    public IdResponseResult(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

