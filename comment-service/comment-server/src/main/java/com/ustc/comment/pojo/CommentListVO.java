package com.ustc.comment.pojo;

import com.ustc.common.result.ListVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ClassName: CommentListVO
 * Package: com.ustc.comment.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CommentListVO extends ListVO<CommentVO> {

    /**
     * 总评论数量（包括二级评论）
     */
    @SuppressWarnings("AlibabaPojoNoDefaultValue")
    Long allCount = 0L;

}
