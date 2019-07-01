package com.changex.blog.core.enums;

public enum SendTypeEnum {
    text(10010, "文本"),

    emoji(10020,"表情"),

    image(10030,"图片");



    private int code;
    private String msg;

    private SendTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static SendTypeEnum getEnum(int code) {
        switch (code) {
            case 10010:
                return text;
            case 10020:
                return emoji;
            case 10030:
                return image;
            default:
                return null;
        }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
