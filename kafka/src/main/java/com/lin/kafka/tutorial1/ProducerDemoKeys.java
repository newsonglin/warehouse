package com.lin.kafka.tutorial1;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * The class in learn/exercises project
 *
 * @author Songlin Li
 * @since 1/19/2022
 */
public class ProducerDemoKeys {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
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
        //Send data
        for (int i=0;i<10;i++) {
            String topic="second_topic";
            String value="bei li lou "+i;
            String key="id_"+i;

            // If you run this method multiple times, you will find producer record with the same key always send to the same partition.
            // Partition number below is just demo
            // id_0-->Partition 1
            // id_1-->Partition 3
            // id_2-->Partition 5
            // id_3-->Partition 3
            // id_4-->Partition 2
            // id_5-->Partition 5
            // id_6-->Partition 0
            // id_7-->Partition 5
            // id_8-->Partition 1
            // id_9-->Partition 2

            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key,value);
            producer.send(record, (recordMetadata, e) -> {
                if(e==null){
                    System.out.println("Key = "+key+",Topic = " + recordMetadata.topic()+","
                    +"Partition = "+recordMetadata.partition()+","
                    +"Offset = "+recordMetadata.offset()+ ","
                    +"Timestamp ="+recordMetadata.timestamp());
                }else{
                    System.out.println("Error Occurs"+e.getMessage());
                }
            }).get(); //block the .send to make it synchronous -- don't do this in production
            //Without get, all records will be sent asynchronous, no order by id
        }
        producer.flush();
        producer.close();
    }
}
