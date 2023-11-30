package com.ustc.user.dto;

import lombok.Data;

/**
 * ClassName: UserGeneralDTO
 * Package: com.ustc.user.dto
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:07
 * @Version 1.0
 */
@Data
public class UserGeneralDTO {

    /**
     * id
     */
    Integer id;

    /**
     * 用户id
     */
    Integer userId;

    /**
     * 累计点赞数
     */
    Integer likeNum;

    /**
     * 粉丝数
     */
    Integer fansNum;

    /**
     * 评论数
     */
    Integer commentNum;

    /**
     * 收藏数
     */
    Integer collectNum;

    /**
     * 访问数
     */
    Integer viewNum;

    /**
     * 博客数
     */
    Integer blogNum;

    /**
     * 作者周排行
     */
    Double weekRank;

    /**
     * 作者总排行
     */
    Double totalRank;

}
