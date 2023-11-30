package com.ustc.resource.pojo;

import lombok.Data;

/**
 * ClassName: City
 * Package: com.ustc.resource.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Data
public class City {

    /**
     * 城市id
     */
    Integer id;

    /**
     * 城市名称
     */
    String name;

    /**
     * 所属省份的id
     */
    Integer provinceId;

}
