package com.changex.blog.core.pojo.dto;

import lombok.Data;

/**
 * @author Xie Chenxi
 * @date 2019-01-22 10:51
 */
@Data
public class WxCheckerDTO {
    private String url;
    private String jsapiTicket;
    private String nonceStr;
    private String timestamp;
    private String signature;
    private String appId;
}
