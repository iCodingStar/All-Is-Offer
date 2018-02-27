package cn.codingstar.offer.demo;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: KafkaProperties.java
 * @time: 2018/2/16 16:44
 * @software: Intellij Idea
 * @desc:Kafka 基本属性配置
 */
public interface KafkaProperties {
    String ZK_CONNECT = "192.168.11.200:2181";
    String GROUP_ID = "group1";
    String TOPIC = "topic1";
    String KAFKA_SERVER_URL = "192.168.11.200";
    int KAFKA_SERVER_PORT = 9092;
    int KAFKA_PRODUCER_SIZE = 64 * 1024;
    int CONNECT_TIME_OUT = 20000;
    int RECONNECT_INTERVAL = 10000;
    String TOPIC_TWO = "topic2";
    String TOPIC_THREE = "topic3";
    String CLIENT_ID = "SimpleConsumerClientDemo";
}
