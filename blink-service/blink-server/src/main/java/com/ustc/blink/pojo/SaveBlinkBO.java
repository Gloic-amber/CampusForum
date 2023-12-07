package com.ustc.blink.pojo;

import lombok.Data;

/**
 * @author css
 */
@Data
public class SaveBlinkBO {

    /**
     * 用户id
     */
    Integer userId;

    /**
     * 学校代码
     */
    Integer schoolCode;

    /**
     * 动态内容
     */
    String content;

}