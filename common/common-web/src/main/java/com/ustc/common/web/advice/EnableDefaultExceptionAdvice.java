package com.ustc.common.web.advice;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName: EnableDefaultExceptionAdvice
 * Package: com.ustc.common.web.advice
 * Description: Web程序默认异常处理器开关
 *
 * @Author Gloic
 * @Create 2023/11/28 15:38
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DefaultExceptionAdvice.class)
public @interface EnableDefaultExceptionAdvice {

}
