package com.changex.blog.core.resource.result;/**
 * Created by fengchu on 16/7/27 下午12:37.
 */


import java.util.List;

/**
 * @author Feng Chu
 * @date 16/7/27 下午12:37
 */
public class ListResponseResult<T> extends ResponseResult {

    private List<T> dataList;

    public ListResponseResult() {

    }

    public ListResponseResult(ResponseResult responseResult) {
        super(responseResult);
    }

    public ListResponseResult(List<T> dataList) {
        this.dataList = dataList;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
