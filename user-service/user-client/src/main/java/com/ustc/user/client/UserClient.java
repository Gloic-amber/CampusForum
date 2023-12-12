package com.ustc.user.client;

import com.ustc.common.result.RestResult;
import com.ustc.user.dto.UserDTO;
import com.ustc.user.dto.UserGeneralDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: UserClient
 * Package: com.ustc.user.client
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:05
 * @Version 1.0
 */
@FeignClient(value = "user-server")
public interface UserClient {

    /**
     * 获取用户公开信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/user")
    RestResult<UserDTO> getByUserId(@RequestParam("id") Integer id);

    /**
     * 批量获取用户信息
     *
     * @param userIdList 用户id列表
     * @return key为用户id，value为用户信息
     */
    @PostMapping("/user/list")
    RestResult<Map<Integer, UserDTO>> getUserList(@RequestParam("userIdList") List<Integer> userIdList);

    /**
     * 批量获取用户信息
     *
     * @param userIdList 用户id列表
     * @return key为用户id，value为用户信息
     */
    @PostMapping("/user/list")
    RestResult<Map<Integer, UserDTO>> getUserList(@RequestParam("userIdList") Set<Integer> userIdList);

    /**
     * 获取用户关注列表
     *
     * @param userId 用户id
     * @return 关注列表
     */
    @GetMapping("/user/followId")
    RestResult<List<Integer>> getFollowIdList(@RequestParam("userId") Integer userId);

    /**
     * 批量查询用户各项数据统计数据
     *
     * @param userIdList 用户id列表
     * @return 批量用户统计数据
     */
    @GetMapping("/user/general/map")
    RestResult<Map<Integer, UserGeneralDTO>> getUserGeneralList(@RequestParam("userIdList") List<Integer> userIdList);

}
