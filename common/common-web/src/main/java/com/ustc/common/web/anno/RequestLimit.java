package com.ustc.common.web.anno;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * ClassName: RequestLimit
 * Package: com.ustc.common.web.anno
 * Description: Request 请求限制拦截
 *
 * @Author Gloic
 * @Create 2023/11/28 15:41
 * @Version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RequestLimit {

    /**
     * 允许访问的次数，默认值120
     */
    int count() default 120;

    /**
     * 间隔的时间段，单位秒，默认值60
     */
    int time() default 60;

    /**
     * 访问达到限制后需要等待的世界，单位秒，默认值300
     */
    int waits() default 300;

}
