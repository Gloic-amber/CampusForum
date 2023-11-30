package com.ustc.user.pojo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: UserFollow
 * Package: com.ustc.user.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:25
 * @Version 1.0
 */
@Data
public class UserFollow {

    /**
     * id
     */
    Integer id;

    /**
     * 粉丝id
     */
    Integer fansId;

    /**
     * 关注者id
     */
    Integer followId;

    /**
     * 备注
     */
    String note;

    /**
     * 状态码 0->未关注;1->已关注
     */
    Integer status;

    /**
     * 创建时间
     */
    Timestamp createTime;

    /**
     * 是否已经删除，0未删除，1已删除
     */
    Integer deleted;

}
