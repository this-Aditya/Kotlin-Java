package org.example.kafka_avro.consumer;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.person.info.Person;

import java.util.Collections;
import java.util.Properties;

public class KafkaAvroConsumerV1 {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("group.id", "my-avro-consumer-group");
        properties.setProperty("enable.auto.commit", "false");
        properties.setProperty("auto.offset.reset", "earliest");

        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", KafkaAvroDeserializer.class.getName());
        properties.setProperty("schema.registry.url", "https://127.0.0.1:8081");
        properties.setProperty("specific.avro.reader", "true");

        try (KafkaConsumer<String, Person> kafkaConsumer = new KafkaConsumer<>(properties)) {
            String topic = "person-avro";

            kafkaConsumer.subscribe(Collections.singleton(topic));
            System.out.println("Waiting for data....");

            while (true) {
                ConsumerRecords<String, Person> records = kafkaConsumer.poll(500);
                for (ConsumerRecord<String, Person> record: records) {
                    Person person = record.value();
                    System.out.println(person);
                }
            kafkaConsumer.commitAsync();
            }


        }

    }
}
