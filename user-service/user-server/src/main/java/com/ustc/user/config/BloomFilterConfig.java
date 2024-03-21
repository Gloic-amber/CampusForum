package com.ustc.user.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.ustc.user.mapper.UserMapper;
import com.ustc.user.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.List;

import static com.ustc.user.utils.RedisConstants.USER_SERVICE_INFO_KEY;

/**
 * ClassName: BloomFilterConfig
 * Package: com.ustc.user.config
 * Description: 布隆过滤器的初始化
 *
 * @author Gloic
 * @version 1.0
 * @create 2024/3/21
 */

@Configuration
public class BloomFilterConfig {

    private static final double FPP = 0.05; //误判率

    @Resource
    private UserMapper userMapper;

    @Bean
    public BloomFilter<CharSequence> bloomFilter(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id");
        List<User> users = userMapper.selectList(queryWrapper);
        long number = users.size();
        BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), number, FPP);
        for (int i = 0; i < number; i++) {
            bloomFilter.put(USER_SERVICE_INFO_KEY+users.get(i).getId());
        }
        return bloomFilter;
    }
}
