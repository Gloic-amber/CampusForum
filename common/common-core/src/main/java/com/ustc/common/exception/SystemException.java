package com.ustc.common.exception;

/**
 * ClassName: SystemException
 * Package: com.ustc.common.exception
 * Description: 系统异常，一般是比较严重的问题，需要针对该异常进行处理
 *              如：数据库更新失败、RPC调用失败等
 *
 * @Author Gloic
 * @Create 2023/11/28 14:41
 * @Version 1.0
 */
public class SystemException extends  BaseException{

    public SystemException() {
        super("系统异常");
    }

    public SystemException(String message) {
        super(message, 500);
    }

    public SystemException(String message, Integer code) {
        super(message, code);
    }

    public SystemException(String message, Integer code, Throwable cause) {
        super(message, code, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

}
