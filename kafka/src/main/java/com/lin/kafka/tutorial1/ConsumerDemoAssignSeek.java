package com.lin.kafka.tutorial1;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 1/19/2022
 */
public class ConsumerDemoAssignSeek {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ConsumerDemoAssignSeek.class);
        String bootstrapServer = "127.0.0.1:9092";
        String topic = "second_topic";
        //Create consumer config
        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());


        //Create consumer
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);

        //Assign
        TopicPartition partitionReadFrom = new TopicPartition(topic, 1);
        consumer.assign(Arrays.asList(partitionReadFrom));

        //Seek
        long offsetReadFrom = 5l;
        consumer.seek(partitionReadFrom, offsetReadFrom);


        int recordTobeRead = 5;
        int recordReadSoFar = 0;
        boolean continueRead = true;
        while (continueRead) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));

            for (ConsumerRecord record : records) {
                logger.info("Key:" + record.key() + ",Value:" + record.value() + ",Partition:" + record.partition() + ",Offset:" + record.offset());
                recordReadSoFar++;
                if (recordReadSoFar > recordTobeRead) {
                    continueRead = false;
                    break;
                }
            }
        }
    }
}
