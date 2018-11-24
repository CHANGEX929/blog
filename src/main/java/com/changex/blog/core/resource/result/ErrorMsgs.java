package com.changex.blog.core.resource.result;

/**
 * @Author Xie Chenxi
 * @Date 2018/11/23 23:16
 */
public class ErrorMsgs {
    public static final String RESOURCE_NOT_FOUND = "resource not found";

    public static final String METHOD_NOT_ALLOWED = "method not allowed";
    public static final String INTERNAL_SERVER_ERROR = "internal server error";
    public static final String INVALID_PROP = "invalid param";


    // 正确响应
    public static final String SUCCESS = "";

    // 账户无权限
    public static final String ACCESS_ID_NOT_EXIST = "wrong access id";
    // 签名不一致
    public static final String INVALID_SIGNATURE = "invalid signature";
    // 禁止访问
    public static final String ACCESS_BARRED = "access barred";

    public static final String RESOURCE_DELETED = "resource deleted";
    // 请求次数过多
    public static final String OVER_FREQUENCY = "over frequency";

    // 用户名不正确，没有该用户
    public static final String INVALID_ACCOUNT = "wrong account";
    // 密码不正确
    public static final String INVALID_PASSWORD = "wrong password";
    // 验证码不正确
    public static final String INVALID_CAPTCHA = "wrong captche";
    // 账户已注册
    public static final String ACCOUNT_EXIST = "account exist";
    // 账户无权限
    public static final String WITHOUT_AUTHORITY = "without authority";
    // 非法的账号
    public static final String INVALID_FORMAT = "invalid format";
    // 登陆超时
    // public static final int LOGIN_TIMEOUT = 4160;

    // 已经是最新版本
    public static final String LATEST_VERSION = "latest version";
    // 版本过期停止服务
    public static final String VERSION_EXPIRE = "version exprire";
    // // 无数据
    // public static final String NO_DATA = "no data";

    // 亲友已关注
    public static final String FRIEND_FOLLOWED = "friend followed";

    // 禁止关注自己
    public static final String CAN_NOT_FOLLOW_YOURSELF = "can not follow yourself";


    // 微信强关系已被用户绑定
    public static final String WECHAT_ALREADY_BOUND = "strong wechat already bound";
    // 微信强关系未被用户绑定
    public static final String WECHAT_NOT_BOUND = "strong wechat not bound";


    //积分不够
    public static final String NOT_ENOUGH_POINTS = "not enough points";

    //账号在其他连锁已经认证
    public static final String ALREADY_AUDITED_IN_OTHER_STORE = "already audited in other store";
    //账号已经在本连锁认证
    public static final String ALREADY_AUDITED_IN_STORE = "already audited in store";

    //容联电话已欠费
    public static final String RONG_LIAN_CALL_OWED = "call owed";
    //容联鉴权异常
    public static final String RONG_LIAN_AUTH_EXCEPTION = "auth exception";

    //没有该设备
    public static final String INVALID_DEVICE = "invalid device";
    //设备已绑定
    public static final String DEVICE_BOUND = "device bound";
    //设备未绑定
    public static final String DEVICE_NOT_BOUND = "device not bound";
}
