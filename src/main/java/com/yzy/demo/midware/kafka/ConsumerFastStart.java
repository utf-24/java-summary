package com.yzy.demo.midware.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.Set;

/**
 * 代码清单1-2
 * Created by 朱小厮 on 2018/7/21.
 */
public class ConsumerFastStart {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "a";
    public static final String groupId = "group.demo1";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer",
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("bootstrap.servers", brokerList);
        properties.put("group.id", groupId);

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(Collections.singletonList(topic));

        while (true) {
            ConsumerRecords<String, String> records =
                    consumer.poll(Duration.ofMillis(1000));

            // 从指定offset消费
            //Set<TopicPartition> assignment = consumer.assignment();
            //for (TopicPartition tp: assignment) {
            //    consumer.seek(tp, 0);
            //}
            //records = consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.value());
            }
        }
    }
}