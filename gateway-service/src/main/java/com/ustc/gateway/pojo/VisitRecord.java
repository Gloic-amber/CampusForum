package com.ustc.gateway.pojo;

import cn.hutool.core.net.Ipv4Util;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * ClassName: VisitRecord
 * Package: com.ustc.gateway.pojo
 * Description:
 *
 * @Author Gloic
 * @Create 2023/11/28 16:59
 * @Version 1.0
 */
@Data
@TableName(value = "visit_log")
public class VisitRecord {

    /**
     * 主键
     */
    @ToString.Exclude
    Long id;

    /**
     * ip地址
     */
    @ToString.Exclude
    Long ip;

    /**
     * 请求方法
     */
    String method;

    /**
     * 请求资源路径
     */
    String uri;

    /**
     * 请求url参数
     */
    String queryParam;

    /**
     * 请求状态码
     */
    Integer status;

    /**
     * 用户id
     */
    Long userId;

    /**
     * 请求发起时间
     */
    @ToString.Exclude
    LocalDateTime creatTime;

    public void setIp(String ip) {
        this.ip = Ipv4Util.ipv4ToLong(ip);
    }

    @ToString.Include(name = "ipv4", rank = 100)
    public String printIpv4() {
        return Ipv4Util.longToIpv4(ip);
    }

}
