package com.ustc.resource.exception;

import com.ustc.common.exception.BusinessException;

/**
 * ClassName: FileException
 * Package: com.ustc.resource.exception
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
public class FileException extends BusinessException {

    public FileException() {
        super("文件异常");
    }

    public FileException(String errorMessage) {
        super(errorMessage);
    }

}
