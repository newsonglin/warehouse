package com.lin.kafka.tutorial1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 1/14/2022
 */
public class ProducerDemo {
    public static void main(String[] args) {
        //Create producer properties
        //property keys can be found here https://kafka.apache.org/documentation/#producerconfigs
        Properties properties = new Properties();

        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");

        //Kafka will convert whatever we send to bytes, so serializer need be specified
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        //Create producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        //create producer record
        ProducerRecord<String, String> record = new ProducerRecord<>("first_topic", "hello world");
        //Send data
        producer.send(record);
        producer.flush();
        producer.close();
    }
}
