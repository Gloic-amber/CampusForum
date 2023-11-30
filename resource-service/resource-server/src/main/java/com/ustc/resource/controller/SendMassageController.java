package com.ustc.resource.controller;

import com.ustc.common.result.RestResult;
import com.ustc.resource.pojo.Mail;
import com.ustc.resource.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * ClassName: SendMassageController
 * Package: com.ustc.resource.controller
 * Description: 信息发送
 *
 * @Author Gloic
 * @Create 2023/11/30
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/send")
@Validated
public class SendMassageController {

    @Resource
    private MailService mailService;

    @PostMapping("/mail")
    public RestResult<Object> sendMail(@NotNull Mail mail) {
        try {
            mailService.sendMail(mail);
            return RestResult.ok(null, "发送成功");
        } catch (Exception e) {
            return RestResult.fail("发送失败");
        }
    }

}
