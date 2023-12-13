package com.ustc.blog.content.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.blog.content.pojo.BlogDTO;
import com.ustc.blog.content.pojo.BlogDoc;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: BlogDTOMapper
 * Package: com.ustc.blog.content.mapper
 * Description:
 *
 * @Author Gloic
 * @Create 2023/12/13
 * @Version 1.0
 */

@Mapper
public interface BlogDTOMapper extends BaseMapper<BlogDTO> {
}
