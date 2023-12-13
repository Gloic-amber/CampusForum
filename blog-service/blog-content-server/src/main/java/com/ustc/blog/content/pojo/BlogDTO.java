package com.ustc.blog.content.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * ClassName: BlogDTO
 * Package: com.ustc.blog.content.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/12/13
 * @Version 1.0
 */

@Data
@TableName("blog")
public class BlogDTO {
    /**
     * 博客id
     */
    @Id
    Integer id;

    /**
     * 作者id
     */
    @Field(type = FieldType.Integer)
    Integer authorId;

    /**
     * 标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", copyTo = "descriptiveContent")
    String title;

    /**
     * 描述
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word", copyTo = "descriptiveContent")
    String description;

    /**
     * 院校代码
     */
    @Field(type = FieldType.Integer)
    Integer schoolCode;

    /**
     * 封面图
     */
    @Field(type = FieldType.Keyword, index = false)
    String coverImage;

    /**
     * 创建时间
     */
    @Field(type = FieldType.Date, pattern = "uuuu-MM-dd HH:mm:ss")
    Date createTime;

    /**
     * 发表时间
     */
    @Field(type = FieldType.Date, pattern = "uuuu-MM-dd HH:mm:ss")
    Date releaseTime;

    /**
     * 修改时间
     */
    @Field(type = FieldType.Date, pattern = "uuuu-MM-dd HH:mm:ss")
    Date modifiedTime;

    /**
     * 发表状态（1表示已发表、2表示未发表、3为仅自己可见、4为回收站、5为审核中）
     */
    @Field(type = FieldType.Integer)
    Integer status;

    /**
     * 博客创作类型：1. 原创; 2. 转载
     */
    @Field(type = FieldType.Integer)
    Integer writeType;


}
