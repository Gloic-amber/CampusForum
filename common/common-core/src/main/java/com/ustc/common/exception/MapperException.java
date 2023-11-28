package com.ustc.common.exception;

/**
 * ClassName: MapperException
 * Package: com.ustc.common.exception
 * Description: 数据库异常，一般很少出现，但往往都是由于系统异常引起的。
 *              如：更新失败、插入失败、查询异常等
 *              抛出该异常时往往存在两部分信息，一是返回给用户的提示信息，二是该条数据
 *
 * @Author Gloic
 * @Create 2023/11/28 14:39
 * @Version 1.0
 */
public class MapperException extends SystemException{

    private Object data;

    public MapperException() {
        super();
    }

    public MapperException(String message) {
        super(message);
    }

    public MapperException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public MapperException(String message, Object data, Integer code) {
        super(message, code);
        this.data = data;
    }

    /**
     * 获取异常数据信息，便于开发者排查
     *
     * @return 可能是一个实体类，也可能是一个字符串，也可能为null
     */
    public Object getData() {
        return data;
    }
}
