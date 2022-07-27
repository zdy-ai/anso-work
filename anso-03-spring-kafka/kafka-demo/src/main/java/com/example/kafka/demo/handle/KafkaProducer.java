package com.example.anso03springkafka.handle;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Package: com.example.anso03springkafka.handle
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/25 9:45
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
@Slf4j
@Component
@AllArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 发送数据
     *
     * @param topic 主题
     * @param msg   消息
     */
    public void sendMessage(String topic, String msg) {
        log.info("开始发送数据 topic:{}, msg:{}", topic, msg);
        try {
            kafkaTemplate.send(topic, msg);
        } catch (Exception e) {
            log.error("kafka发送消息失败:{}", e.getMessage());
        }
        log.info("发送数据结束");
    }
}
