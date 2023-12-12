package com.ustc.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.user.pojo.UserSafety;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.io.Serializable;

/**
 * ClassName: UserSafetyMapper
 * Package: com.ustc.user.mapper
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */

@Mapper
public interface UserSafetyMapper extends BaseMapper<UserSafety> {

    /**
     * 通过邮箱查找用户账号密码信息
     *
     * @param mail 邮箱
     * @return 用户账号安全数据
     */
    @Select("select * from `user`.`user_safety` where `mail` = #{mail}")
    UserSafety selectByMail(@Param("mail") String mail);

    /**
     * 更新密码
     *
     * @param id       用户id
     * @param password 密码
     * @return 影响的行数
     */
    @Update("update `user`.`user_safety` set `password` = #{password} where `user_id` = #{id};")
    int updatePasswordById(@Param("id") Integer id, @Param("password") String password);

    /**
     * 更新邮箱
     *
     * @param id   用户id
     * @param mail 新邮箱
     * @return 影响的行数
     */
    @Update("update `user`.`user_safety` set `mail` = #{mail} where `user_id` = #{id} ")
    int updateMailById(@Param("id") Integer id, @Param("mail") String mail);

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     * @return 影响的行数
     */
    @Override
    @Update("update `user_safety` set `deleted` = #{id} where `user_id` = #{id} and `deleted` = 0")
    int deleteById(@Param("id") Serializable id);
}
