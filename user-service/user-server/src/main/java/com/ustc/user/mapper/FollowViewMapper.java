package com.ustc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.user.pojo.FollowView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ClassName: FollowViewMapper
 * Package: com.ustc.user.mapper
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Mapper
public interface FollowViewMapper extends BaseMapper<FollowView> {
    /**
     * 获取用户关注作者的id列表
     *
     * @param userId 用户id
     * @return 被用户关注的id列表
     */
    @Select("select follow_id from user.follow_view where user_id = #{userId} and status = 1;")
    List<Integer> selectFollowIdByUserId(int userId);
}
