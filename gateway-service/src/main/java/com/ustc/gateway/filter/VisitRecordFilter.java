package com.ustc.gateway.filter;

import com.ustc.gateway.pojo.VisitRecord;
import com.ustc.gateway.service.VisitRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * ClassName: VisitRecordFilter
 * Package: com.ustc.gateway.filter
 * Description: 访问记录过滤器，保存访问记录，最先执行
 *
 * @Author Gloic
 * @Create 2023/11/28 16:56
 * @Version 1.0
 */
@Slf4j
@Component
public class VisitRecordFilter implements GlobalFilter, Ordered {

    @Resource
    VisitRecordService visitRecordService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        VisitRecord visitRecord = visitRecordService.build(exchange);

        visitRecordService.put(exchange, visitRecord);
        // 请求后执行保存
        return chain.filter(exchange).then(saveRecord(exchange));
    }

    private Mono<Void> saveRecord(ServerWebExchange exchange) {
        return Mono.fromRunnable(() -> visitRecordService.add(exchange));
    }

    @Override
    public int getOrder() {
        return -10000;
    }

}
