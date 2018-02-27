package cn.codingstar.offer.demo;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: KafkaProducer.java
 * @time: 2018/2/16 16:51
 * @software: Intellij Idea
 * @desc:
 */
public class KafkaProducer extends Thread {

    private final Producer<Integer, String> producer;
    private final String topic;
    private final Properties properties = new Properties();

    public KafkaProducer(String topic) {
        this.topic = topic;
        properties.put("serializer.class", "kafka.serializer.StringEncoder");
        properties.put("metadata.broker.list", "192.168.11.200:9092");
        producer = new Producer<Integer, String>(new ProducerConfig(properties));
    }

    @Override
    public void run() {
        int messageNo = 1;
        while (true) {
            String message = "message_" + messageNo;
            System.out.println("send : " + message);
            producer.send(new KeyedMessage<Integer, String>(topic, message));
            messageNo++;
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}