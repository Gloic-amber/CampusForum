package com.ustc.user.controller;

import com.ustc.common.exception.BusinessException;
import com.ustc.common.web.auth.AuthHelper;
import com.ustc.user.pojo.FansViewListVO;
import com.ustc.user.pojo.FollowViewListVO;
import com.ustc.user.service.UserFollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * ClassName: FollowController
 * Package: com.ustc.user.controller
 * Description: 用户关注
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Validated
public class FollowController {

    /**
     * 默认每页20条
     */
    private final int pageSize = 20;

    @Resource
    private UserFollowService userFollowService;

    /**
     * 获取关注列表
     *
     * @param page 当前页
     * @return 关注列表数据
     */
    @GetMapping("/follow")
    public FollowViewListVO getFollowList(@RequestParam(defaultValue = "1") int page, Integer userId) {
        if (userId == null) {
            userId = AuthHelper.getCurrentUserId();
            if (userId == null) {
                throw new BusinessException("参数异常");
            }
        }
        return userFollowService.getFollowList(userId, page, pageSize);
    }

    /**
     * 获取粉丝列表
     *
     * @param page 当前页
     * @return 粉丝列表数据
     */
    @GetMapping("/fans")
    public FansViewListVO getFansList(@RequestParam(defaultValue = "1") int page, Integer userId) {
        if (userId == null) {
            userId = AuthHelper.getCurrentUserId();
            if (userId == null) {
                throw new BusinessException("参数异常");
            }
        }
        return userFollowService.getFansList(userId, page, pageSize);
    }

    /**
     * 关注其他用户
     *
     * @param followId 被关注的用户id
     * @return 关注状态，若成功则为true，取关则为false
     */
    @PostMapping("/follow")
    public Boolean doFollow(@NotNull Integer followId) {
        Integer id = AuthHelper.getCurrentUserIdOrExit();
        return userFollowService.follow(id, followId);
    }

    /**
     * 获取关注列表id
     */
    @GetMapping("/followId")
    public List<Integer> getFollowIdList(@NotNull Integer userId) {
        return userFollowService.getFollowIdList(userId);
    }

}
