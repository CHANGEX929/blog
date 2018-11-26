/*
 * Copyright (c) 2014-2020 CareLinker Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * CareLinker. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with CareLinker.
 *
 */
package com.changex.blog.core.resource.result;


import java.util.List;

/**
 * @author fengchu
 * @Comments
 * @Time 2015年8月18日 下午5:05:15
 * @Version 1.0.0
 * @ModifiedBy
 * @ModifiedDate
 * @Modified Why & What is modified
 */
public class ResponseResultFactory {

    public static ResponseResult getSuccess() {
        return new ResponseResult();
    }

    public static IdResponseResult getId(Integer id) {
        return new IdResponseResult(id);
    }

    public static <T> DataResponseResult<T> getData(T t) {
        return new DataResponseResult<>(t);
    }

    public static <T> DataResponseResult<T> getData(ResponseResult responseResult) {
        return new DataResponseResult<>(responseResult);
    }

    public static <T> ListResponseResult<T> getList(List<T> list) {
        return new ListResponseResult<>(list);
    }

    public static <T> ListResponseResult<T> getList(ResponseResult responseResultt) {
        return new ListResponseResult<>(responseResultt);
    }


    public static ResponseResult getResourceNotFound() {

        return new ResponseResult(ErrorMsgs.RESOURCE_NOT_FOUND, false,
                ErrorCodes.RESOURCE_NOT_FOUND);

    }


    public static ResponseResult getInvalidCaptcha() {

        return new ResponseResult(ErrorMsgs.INVALID_CAPTCHA, false,
                ErrorCodes.INVALID_CAPTCHA);

    }

    public static ResponseResult getAccountExist() {

        return new ResponseResult(ErrorMsgs.ACCOUNT_EXIST, false,
                ErrorCodes.ACCOUNT_EXIST);

    }

    public static ResponseResult getWithoutAuthority() {

        return new ResponseResult(ErrorMsgs.WITHOUT_AUTHORITY, false,
                ErrorCodes.WITHOUT_AUTHORITY);

    }

    public static ResponseResult getInvalidAccount() {

        return new ResponseResult(ErrorMsgs.INVALID_ACCOUNT, false,
                ErrorCodes.INVALID_ACCOUNT);

    }

    public static ResponseResult getInvalidPassword() {

        return new ResponseResult(ErrorMsgs.INVALID_PASSWORD, false,
                ErrorCodes.INVALID_PASSWORD);

    }

    public static ResponseResult getInvalidFormat() {

        return new ResponseResult(ErrorMsgs.INVALID_FORMAT, false,
                ErrorCodes.INVALID_FORMAT);

    }

    public static ResponseResult getLatestVersion() {

        return new ResponseResult(ErrorMsgs.LATEST_VERSION, false,
                ErrorCodes.LATEST_VERSION);

    }

    public static ResponseResult getInvalidProp() {

        return new ResponseResult(ErrorMsgs.INVALID_PROP, false,
                ErrorCodes.INVALID_PROP);
    }


    public static ResponseResult getWechatNotBound() {

        return new ResponseResult(ErrorMsgs.WECHAT_NOT_BOUND, false, ErrorCodes.WECHAT_NOT_BOUND);
    }

    public static ResponseResult getInvalidSign() {

        return new ResponseResult(ErrorMsgs.INVALID_SIGNATURE, false, ErrorCodes.INVALID_SIGNATURE);
    }

}
