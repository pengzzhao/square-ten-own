package com.tensquare.sms.listener;

import com.aliyuncs.exceptions.ClientException;
import com.tensquare.sms.utils.SmsUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author pengzhao
 * @Title: SmsListener
 * @ProjectName tensquare_parent
 * @Description: TODO
 * @date 2019/1/221:29
 */
@Log4j2
@Component
@RabbitListener(queues = "sms")
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @Value("${aliyun.sms.template_code}")
    private String template_code;

    @Value("${aliyun.sms.sign_name}")
    private String sign_name;

    @RabbitHandler
    public void sendSms(Map<String, String> message) {
        String mobile = message.get("mobile");
        String checkCode = message.get("code");
        log.debug("手机号：" + mobile);
        log.debug("验证码：" + checkCode);

        try {
            smsUtil.sendSms(mobile, template_code, sign_name, " {\"checkCode\":\"" + checkCode + "\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
