package com.lin.kafka.tutorial1;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 1/19/2022
 */
public class ProducerDemoWithCallback {
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
        for (int i=0;i<10;i++) {
            producer.send(record, (recordMetadata, e) -> {
                if(e==null){
                    System.out.println("Topic = " + recordMetadata.topic()+"\n"
                    +"Partition = "+recordMetadata.partition()+"\n"
                    +"Offset = "+recordMetadata.offset()+ "\n"
                    +"Timestamp ="+recordMetadata.timestamp());
                }else{
                    System.out.println("Error Occurs"+e.getMessage());
                }
            });
        }
        producer.flush();
        producer.close();
    }
}
