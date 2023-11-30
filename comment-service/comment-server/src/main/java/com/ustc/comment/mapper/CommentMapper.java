package com.ustc.comment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.comment.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: CommentMapper
 * Package: com.ustc.comment.mapper
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */

@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
