package com.ustc.blink.controller;

import com.ustc.blink.pojo.BlinkView;
import com.ustc.blink.pojo.BlinkViewListVO;
import com.ustc.blink.pojo.SaveBlinkBO;
import com.ustc.blink.pojo.UpdateBlinkBO;
import com.ustc.blink.service.BlinkService;
import com.ustc.blink.service.BlinkViewService;
import com.ustc.common.exception.BusinessException;
import com.ustc.common.web.auth.AuthHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * 动态（表白墙）相关接口
 *
 * @author css
 */
@Slf4j
@RestController
@RequestMapping("/blink")
@Validated
public class BlinkController {

    private static final int PAGE_SIZE = 20;

    @Resource
    private BlinkViewService blinkViewService;

    @Resource
    private BlinkService blinkService;

    /**
     * 获取动态内容
     *
     * @param id 动态id
     */
    @GetMapping
    public BlinkView getBlink(@NotNull Integer id) {
        return blinkViewService.getById(id);
    }

    /**
     * 创建动态
     *
     * @param content    动态内容
     * @param schoolCode 院校代码，从cookie中获取
     */
    @PostMapping
    public void createBlink(@NotNull String content, @CookieValue(required = false) Integer schoolCode) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        SaveBlinkBO saveBlinkBO = new SaveBlinkBO();
        saveBlinkBO.setContent(content);
        saveBlinkBO.setUserId(id);
        saveBlinkBO.setSchoolCode(schoolCode);
        blinkService.create(saveBlinkBO);
    }

    /**
     * 修改动态内容
     */
    @PutMapping
    public void updateBlink(@Validated UpdateBlinkBO blinkBO) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        blinkBO.setUserId(id);
        blinkService.update(blinkBO);
    }

    /**
     * 删除动态
     *
     * @param blinkId 动态id
     */
    @DeleteMapping
    public void deleteBlink(@NotNull Integer blinkId) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        blinkService.remove(blinkId, id);
    }

    /**
     * 获取最新动态列表
     *
     * @param page       第几页
     * @param schoolCode 院校代码，哪个学校的
     */
    @GetMapping("/list")
    public BlinkViewListVO getList(@RequestParam(defaultValue = "1") Integer page, Integer schoolCode) {
        return blinkViewService.getListByTime(page, PAGE_SIZE, schoolCode);
    }

    /**
     * 获取动态列表
     *
     * @param page 第几页
     */
    @GetMapping("/list/self")
    public BlinkViewListVO getSelfList(
            @RequestParam(defaultValue = "1") Integer page,
            Integer userId) {
        if (userId == null) {
            userId = AuthHelper.getCurrentUserId();
            if (userId == null) {
                throw new BusinessException("参数异常");
            }
        }
        return blinkViewService.getSelfList(userId, page, PAGE_SIZE);
    }

}