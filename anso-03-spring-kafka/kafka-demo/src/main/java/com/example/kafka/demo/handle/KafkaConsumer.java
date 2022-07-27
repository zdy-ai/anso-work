package com.example.anso03springkafka.handle;

import com.example.anso03springkafka.vo.ConfigureAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Package: com.example.anso03springkafka.handle
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/25 9:49
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(groupId = ConfigureAPI.KafkaProperties.GROUP_ID, topics = ConfigureAPI.KafkaProperties.TOPIC)
    public void getMessage(Message<?> message) {
        String data = message.getPayload().toString();
        log.info("接收数据：[" + data + "]");
    }
}
