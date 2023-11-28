package com.ustc.common.result;

import lombok.Data;

import java.util.List;

/**
 * ClassName: ListVO
 * Package: com.ustc.common.result
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 14:48
 * @Version 1.0
 */
@SuppressWarnings({"AlibabaPojoNoDefaultValue", "AlibabaPojoMustUsePrimitiveField"})
@Data
public class ListVO<T> implements IListVO<T>{
    /**
     * 查询数据列表
     */
    List<T> records;

    /**
     * 总数
     */
    long total = 0;

    /**
     * 每页显示条数，默认 20
     */
    long size = 20;

    /**
     * 当前页
     */
    long current = 1;
}
