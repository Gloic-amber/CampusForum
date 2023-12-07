package com.ustc.blink.service;

import com.ustc.blink.pojo.Blink;
import com.ustc.blink.pojo.SaveBlinkBO;
import com.ustc.blink.pojo.UpdateBlinkBO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author css
 */
public interface BlinkService extends IService<Blink> {

    /**
     * 新建动态
     *
     * @param blinkBO 博客数据
     */
    void create(SaveBlinkBO blinkBO);

    /**
     * 删除动态
     *
     * @param id     动态id
     * @param userId 用户id
     */
    void remove(int id, int userId);

    /**
     * 更新动态
     *
     * @param blinkBO 动态数据
     */
    void update(UpdateBlinkBO blinkBO);

}