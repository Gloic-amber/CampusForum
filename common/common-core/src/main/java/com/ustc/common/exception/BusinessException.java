package com.ustc.common.exception;

/**
 * ClassName: BusinessException
 * Package: com.ustc.common.exception
 * Description: 普通业务异常，一般是由用户操作导致的，不需要打印日志
 *              如，密码错误、用户不存在等
 *
 * @Author Gloic
 * @Create 2023/11/28 14:38
 * @Version 1.0
 */
public class BusinessException extends BaseException{
    public BusinessException() {
        // 业务异常兜底提示信息
        super("操作异常");
    }

    public BusinessException(String message) {
        super(message, 400);
    }

    public BusinessException(String message, Integer code) {
        super(message, code);
    }

    public BusinessException(String message, Integer code, Throwable cause) {
        super(message, code, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
