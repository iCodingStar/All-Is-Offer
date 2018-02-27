package cn.codingstar.offer.demo;

/**
 * @version: java8
 * @author: CodingStar
 * @contact: shixing.cs@gmail.com
 * @file: Main.java
 * @time: 2018/2/16 17:25
 * @software: Intellij Idea
 * @desc:
 */
public class Main {

    public static void main(String[] args) {
        KafkaProducer producer = new KafkaProducer("topic1");
        producer.start();
        KafkaConsumer consumer = new KafkaConsumer("topic1");
        consumer.start();
    }

}
