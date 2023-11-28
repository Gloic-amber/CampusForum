package com.ustc.common.tool.mybatisconfig;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * ClassName: EnableMybatisPlusIPage
 * Package: com.ustc.common.tool.mybatisconfig
 * Description: MybatisPlus分页功能配置开关类
 *
 * @Author Gloic
 * @Create 2023/11/28 15:27
 * @Version 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MybatisPlusDefaultConfig.class)
public @interface EnableMybatisPlusIPage {

}
