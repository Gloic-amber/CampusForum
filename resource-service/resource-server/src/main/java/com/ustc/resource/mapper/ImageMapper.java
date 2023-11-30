package com.ustc.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.resource.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

/**
 * ClassName: ImageMapper
 * Package: com.ustc.resource.mapper
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */

@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    /**
     * 浏览量 +1
     *
     * @param url 访问的资源
     */
    @Update("update resource.image set visit = visit + 1 where url = #{blogId};")
    void increaseVisit(String url);
}
