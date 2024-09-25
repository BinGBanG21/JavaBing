package com.javabing.train.business.mq;/*
 * ClassName: ConfirmOrderConsumer
 * Package: com.javabing.train.business.mq
 * Description:
 * @Author WangBing
 * @Create 2024/9/25/星期三 10:53
 * @Version 1.0
 **/

import com.alibaba.fastjson.JSON;
import com.javabing.train.business.req.ConfirmOrderDoReq;
import com.javabing.train.business.service.ConfirmOrderService;
import jakarta.annotation.Resource;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(consumerGroup = "default", topic = "CONFIRM_ORDER")
public class ConfirmOrderConsumer implements RocketMQListener<MessageExt> {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderConsumer.class);

    @Resource
    private ConfirmOrderService confirmOrderService;

    @Override
    public void onMessage(MessageExt messageExt) {
        byte[] body = messageExt.getBody();
        ConfirmOrderDoReq req = JSON.parseObject(new String(body), ConfirmOrderDoReq.class);
        MDC.put("LOG_ID", req.getLogId());
                LOG.info("ROCKETMQ收到消息：{}", new String(body));
        confirmOrderService.doConfirm(req);
    }
}