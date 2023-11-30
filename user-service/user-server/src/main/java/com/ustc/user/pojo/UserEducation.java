package com.ustc.user.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

/**
 * ClassName: UserEducation
 * Package: com.ustc.user.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30 11:25
 * @Version 1.0
 */
@Data
public class UserEducation {

    /**
     * 用户名
     */
    @TableId
    String username;

    /**
     * 创建时间
     */
    Timestamp createTime;

    /**
     * 学校名称
     */
    String school;

    /**
     * 学校id
     */
    Integer schoolId;

    /**
     * 专业
     */
    String profession;

    /**
     * 学位程度
     */
    String degree;

    /**
     * 入学时间
     */
    Timestamp startTime;

    /**
     * 毕业时间
     */
    Timestamp endTime;

    /**
     * 图片链接
     */
    String auditImgUrl;

    /**
     * 安全审核状态
     */
    String safetyAuditStatus;

    /**
     * 状态码
     */
    String status;

    /**
     * 更新时间
     */
    Timestamp modifiedTime;

    /**
     * 是否已经删除，0未删除，1已删除
     */
    Integer deleted;

}
