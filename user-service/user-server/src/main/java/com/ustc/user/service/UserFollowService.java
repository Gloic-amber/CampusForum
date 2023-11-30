package com.ustc.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ustc.user.pojo.FansViewListVO;
import com.ustc.user.pojo.FollowViewListVO;
import com.ustc.user.pojo.UserFollow;

import java.util.List;

/**
 * ClassName: UserFollowService
 * Package: com.ustc.user.service
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
public interface UserFollowService extends IService<UserFollow> {

    /**
     * 关注用户，已关注的状态下则取消关注
     *
     * @param userId   用户id（操作者）
     * @param followId 关注者的id
     * @return 返回调用后是否为关注状态，若为关注则返回true、未关注则返回false
     */
    boolean follow(int userId, int followId);

    /**
     * 获取关注列表
     *
     * @param userId   用户od
     * @param page     第几页
     * @param pageSize 页大小
     * @return 关注列表
     */
    FollowViewListVO getFollowList(int userId, int page, int pageSize);

    /**
     * 获取粉丝列表
     *
     * @param userId   用户od
     * @param page     第几页
     * @param pageSize 页大小
     * @return 粉丝列表
     */
    FansViewListVO getFansList(int userId, int page, int pageSize);

    /**
     * 获取关注列表id
     *
     * @param userId 用户id
     * @return id列表
     */
    List<Integer> getFollowIdList(int userId);
}
