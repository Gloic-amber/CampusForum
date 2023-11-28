package com.ustc.common.web.advice;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName: EnableDefaultResponseAdvice
 * Package: com.ustc.common.web.advice
 * Description: Web程序默认响应体包装处理器开关
 *
 * @Author Gloic
 * @Create 2023/11/28 15:39
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(DefaultResponseAdvice.class)
public @interface EnableDefaultResponseAdvice {

}
