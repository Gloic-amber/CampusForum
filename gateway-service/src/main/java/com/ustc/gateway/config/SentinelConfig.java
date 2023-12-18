package com.ustc.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayParamFlowItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: SentinelConfig
 * Package: com.ustc.gateway.config
 * Description:  sentinel限流的配置
 *
 * @Author Gloic
 * @Create 2023/12/18
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "ustc.sentinel.config")
public class SentinelConfig {

    // 限流阈值
    public static Double threshold;

    // 时间窗口
    public static Long time;

    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;

    public SentinelConfig(ObjectProvider<List<ViewResolver>> viewResolversProvider, ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    /**
     * 初始化一个限流的过滤器
     *
     * @return 限流的过滤器
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public GlobalFilter sentinelGatewayFilter() {
        return new SentinelGatewayFilter();
    }

    /**
     * 配置限流的异常处理器
     *
     * @return 异常处理器
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    /**
     * 加载规则
     */
    @PostConstruct
    public void doInit() {
        initGatewayRules();
    }

    /**
     * 配置初始化的限流参数
     */
    public void initGatewayRules() {
        Set<GatewayFlowRule> rules = new HashSet<>();
        // yaml中配置的路由id
        rules.add(new GatewayFlowRule("user-server")
                // 限流维度
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_ROUTE_ID)
                // 限流阈值
                .setCount(threshold)
                // 时间窗口
                .setIntervalSec(time)
        );
        rules.add(new GatewayFlowRule("resource-server")
                // 限流维度
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_ROUTE_ID)
                // 限流阈值
                .setCount(threshold)
                // 时间窗口
                .setIntervalSec(time)
        );
        rules.add(new GatewayFlowRule("comment-server")
                // 限流维度
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_ROUTE_ID)
                // 限流阈值
                .setCount(threshold)
                // 时间窗口
                .setIntervalSec(time)
        );
        rules.add(new GatewayFlowRule("blog-server")
                // 限流维度
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_ROUTE_ID)
                // 限流阈值
                .setCount(threshold)
                // 时间窗口
                .setIntervalSec(time)
        );
        rules.add(new GatewayFlowRule("blog-content-server")
                // 限流维度
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_ROUTE_ID)
                // 限流阈值
                .setCount(threshold)
                // 时间窗口
                .setIntervalSec(time)
        );
        GatewayRuleManager.loadRules(rules);
    }

    public void setThreshold(Double threshold) {
        SentinelConfig.threshold = threshold;
    }

    public void setTime(Long time) {
        SentinelConfig.time = time;
    }
}
