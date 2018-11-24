package com.changex.blog.core.resource.result;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/23 23:14
 */
public class ErrorCodes {
    // 正确响应
    public static final int SUCCESS = 200;
    // 未知错误
    public static final int INTERNAL_SERVER_ERROR = 500;
    // 请求的参数不正确
    public static final int INVALID_PROP = 203;
    // 账户无权限
    public static final int ACCESS_ID_NOT_EXIST = 401;
    // 签名不一致
    public static final int INVALID_SIGNATURE = 402;
    // 禁止访问
    public static final int ACCESS_BARRED = 403;
    // 请求的资源不存在
    public static final int RESOURCE_NOT_FOUND = 404;
    // 请求的方法错误
    public static final int METHOD_NOT_ALLOWED = 405;
    // 资源已被删除
    public static final int RESOURCE_DELETED = 410;

    // 请求次数过多
    public static final int OVER_FREQUENCY = 429;

    // 用户名不正确，没有该用户
    public static final int INVALID_ACCOUNT = 4110;
    // 密码不正确
    public static final int INVALID_PASSWORD = 4120;
    // 验证码不正确
    public static final int INVALID_CAPTCHA = 4130;
    // 账户已注册
    public static final int ACCOUNT_EXIST = 4140;
    // 账户无权限
    public static final int WITHOUT_AUTHORITY = 4150;
    // 非法的账号
    public static final int INVALID_FORMAT = 4160;
    // 登陆超时
    // public static final int LOGIN_TIMEOUT = 4160;

    // 已经是最新版本
    public static final int LATEST_VERSION = 4210;
    // 版本过期停止服务
    public static final int VERSION_EXPIRE = 4220;
    // // 已同步为最新数据
    // public static final int NO_DATA = 4230;


    // 亲友已关注
    public static final int FRIEND_FOLLOWED = 4510;
    // 禁止关注自己
    public static final int CAN_NOT_FOLLOW_YOURSELF = 4520;

    // 微信强关系已被用户绑定
    public static final int WECHAT_ALREADY_BOUND = 4720;
    // 微信强关系未被用户绑定
    public static final int WECHAT_NOT_BOUND = 4730;



    //积分不够
    public static final int NOT_ENOUGH_POINTS = 4810;

    //账号在其他连锁已经认证
    public static final int ALREADY_AUDITED_IN_OTHER_STORE = 4910;
    //账号已经在本连锁认证
    public static final int ALREADY_AUDITED_IN_STORE = 4920;

    //容联电话已欠费
    public static final int RONG_LIAN_CALL_OWED = 5010;
    //容联鉴权异常
    public static final int RONG_LIAN_AUTH_EXCEPTION = 5020;

    // 没有该设备
    public static final int INVALID_DEVICE = 4410;
    // 设备已绑定
    public static final int DEVICE_BOUND = 4420;
    // 设备未绑定
    public static final int DEVICE_NOT_BOUND = 4430;
}
