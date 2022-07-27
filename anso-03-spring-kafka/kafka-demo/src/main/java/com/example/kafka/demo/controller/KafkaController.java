package com.example.anso03springkafka.controller;

import com.example.anso03springkafka.handle.KafkaProducer;
import com.example.anso03springkafka.vo.ConfigureAPI;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Package: com.example.anso03springkafka
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/25 9:38
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Resource
    KafkaProducer kafkaProducer;

    @RequestMapping("/test")
    private String test(@RequestParam(value = "param") String param) {
        kafkaProducer.sendMessage(ConfigureAPI.KafkaProperties.TOPIC, param);
        return "发送成功！";
    }

}
