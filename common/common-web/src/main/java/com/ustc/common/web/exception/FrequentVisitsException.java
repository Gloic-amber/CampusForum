package com.ustc.common.web.exception;

import com.ustc.common.exception.BusinessException;

/**
 * ClassName: FrequentVisitsException
 * Package: com.ustc.common.web.exception
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 15:45
 * @Version 1.0
 */
public class FrequentVisitsException extends BusinessException {
    public FrequentVisitsException(String errorMessage) {
        super(errorMessage);
    }

    public FrequentVisitsException() {
        super("访问频繁");
    }
}
