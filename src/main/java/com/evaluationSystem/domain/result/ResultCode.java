package com.evaluationSystem.domain.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应码枚举，参考HTTP状态码的语义
 *
 * @ClassName : ResultCode
 * @Description :
 * @Author : 张豪
 * @Date: 2023-04-18 14:27:02
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200,"操作成功"),
    //成功
    FAIL(400,"操作失败"),
    //失败
    UNAUTHORIZED(401,"未授权"),
    //未认证（签名错误）
    NOT_FOUND(404,"接口不存在"),
    //接口不存在
    INTERNAL_SERVER_ERROR(500,"服务器内部错误");
    //服务器内部错误

    private final Integer code;
    private final String message;

}
