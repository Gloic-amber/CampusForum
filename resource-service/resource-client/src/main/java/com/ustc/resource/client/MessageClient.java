package com.ustc.resource.client;

import com.ustc.common.result.RestResult;
import com.ustc.resource.client.fuse.MessageClientFuse;
import com.ustc.resource.client.pojo.MailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * ClassName: MessageClient
 * Package: com.ustc.resource.client
 * Description: 消息服务模块接口客户端
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@FeignClient(value = "resource-server", fallback = MessageClientFuse.class, contextId = "MessageClient")
public interface MessageClient {

    /**
     * 发送邮件
     *
     * @param mail 邮件信息
     * @return 发送情况
     */
    @PostMapping(value = "/send/mail", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    RestResult<Object> sendMail(MailDTO mail);

}
