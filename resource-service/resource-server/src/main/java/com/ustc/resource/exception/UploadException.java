package com.ustc.resource.exception;

import com.ustc.common.exception.BusinessException;

/**
 * ClassName: UploadException
 * Package: com.ustc.resource.exception
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
public class UploadException extends BusinessException {

    public UploadException(String errorMessage) {
        super(errorMessage);
    }

}
