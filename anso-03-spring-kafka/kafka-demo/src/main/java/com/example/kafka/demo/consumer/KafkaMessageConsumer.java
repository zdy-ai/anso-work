package com.example.anso03springkafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
@Slf4j
public class KafkaMessageConsumer {

    @Autowired
    KafkaTemplate kafkaTemplate;

    public static final String topic = "TOPIC_1";
//
//    @KafkaListener(topics = topic)
//    public void consumer(ConsumerRecord consumerRecord) {
//        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
//        if (kafkaMassage.isPresent()) {
//            Object o = kafkaMassage.get();
//            log.info(o.toString());
//        }
//        log.info("offset: {} 收到消息: key === {} ", consumerRecord.offset(),
//                new String(consumerRecord.value().toString().getBytes(), StandardCharsets.UTF_8));
//    }


//    @KafkaListener(id = "baz", topics = "myTopic",
//            containerFactory = "kafkaManualAckListenerContainerFactory")
//    public void listen(String data, Acknowledgment ack) {
//        //
//        ack.acknowledge();
//    }
//
//
//    @KafkaListener(id = "qux", topicPattern = "myTopic1")
//    public void listen(@Payload String foo,
//                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) Integer key,
//                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
//                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        //
//    }
//
//    @KafkaListener(id = "list", topics = "myTopic", containerFactory = "batchFactory")
//    public void listen(List<String> list) {
//        //...
//    }
//
//    @KafkaListener(id = "list", topics = "myTopic", containerFactory = "batchFactory")
//    public void listen(List<String> list,
//                       @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) List<Integer> keys,
//                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) List<Integer> partitions,
//                       @Header(KafkaHeaders.RECEIVED_TOPIC) List<String> topics,
//                       @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
//        //...
//    }

    @KafkaListener(topics = topic)
    public void consumer(ConsumerRecord consumerRecord, Acknowledgment ack) {
        Optional<Object> kafkaMassage = Optional.ofNullable(consumerRecord.value());
        if (kafkaMassage.isPresent()) {
            Object o = kafkaMassage.get();
            log.info(o.toString());
        }
        log.info("offset: {} 收到消息: key === {} ", consumerRecord.offset(),
                new String(consumerRecord.value().toString().getBytes(), StandardCharsets.UTF_8));
        ack.acknowledge();
    }
}

