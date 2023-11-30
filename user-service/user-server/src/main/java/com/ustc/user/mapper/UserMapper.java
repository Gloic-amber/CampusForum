package com.ustc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;

/**
 * ClassName: UserMapper
 * Package: com.ustc.user.mapper
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     * @return 影响数据行
     */
    @Override
    int deleteById(Serializable id);
}
