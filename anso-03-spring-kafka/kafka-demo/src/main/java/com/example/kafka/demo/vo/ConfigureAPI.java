package com.example.anso03springkafka.vo;

public class ConfigureAPI {
    public interface KafkaProperties {
        public final static String ZK = "10.0.20.25:2181";
//        public final static String ZK = "192.168.0.134:2181";
        public final static String GROUP_ID = "test02";
        public final static String TOPIC = "test02";
        public final static String BROKER_LIST = "10.0.20.25:9092";
//        public final static String BROKER_LIST = "192.168.0.134:9092";
        public final static int BUFFER_SIZE = 64 * 1024;
        public final static int TIMEOUT = 20000;
        public final static int INTERVAL = 10000;
    }
}
