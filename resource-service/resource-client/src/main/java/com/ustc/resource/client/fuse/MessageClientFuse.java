package com.ustc.resource.client.fuse;

import com.ustc.common.result.RestResult;
import com.ustc.resource.client.MessageClient;
import com.ustc.resource.client.pojo.MailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ClassName: MessageClientFuse
 * Package: com.ustc.resource.client.fuse
 * Description: 消息服务模块接口客户端熔断器
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@Component
public class MessageClientFuse implements MessageClient {

    /**
     * 发送邮件
     *
     * @param mail 邮件信息
     * @return 发送情况
     */
    @Override
    public RestResult<Object> sendMail(MailDTO mail) {
        log.error("Message 服务异常：sendMail(MailDTO mail) 请求失败");
        return RestResult.fail("request fail");
    }

}
