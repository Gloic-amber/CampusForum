package com.ustc.gateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ustc.gateway.pojo.VisitRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: VisitLogMapper
 * Package: com.ustc.gateway.mapper
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 16:58
 * @Version 1.0
 */

@Mapper
public interface VisitLogMapper extends BaseMapper<VisitRecord> {
}
