package com.ustc.user.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: UserSafety
 * Package: com.ustc.user.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:28
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSafety {

    /**
     * 用户id
     */
    @TableId
    Integer userId;

    /**
     * 用户名
     */
    String username;

    /**
     * 密码
     */
    String password;

    /**
     * 邮箱
     */
    String mail;

    /**
     * 手机号
     */
    String mobile;

    /**
     * 是否已经删除，0未删除，1已删除
     */
    Integer deleted;

}
