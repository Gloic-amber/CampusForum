package com.ustc.common.web.exception;

import com.ustc.common.exception.BusinessException;

/**
 * ClassName: UnauthorizedException
 * Package: com.ustc.common.web.exception
 * Description: 用户未登录异常
 *
 * @Author Gloic
 * @Create 2023/11/28 15:45
 * @Version 1.0
 */
public class UnauthorizedException extends BusinessException {

    public UnauthorizedException() {
        super("用户未登录");
    }

}
