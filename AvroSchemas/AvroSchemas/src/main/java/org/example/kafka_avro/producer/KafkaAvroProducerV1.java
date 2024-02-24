package org.example.kafka_avro.producer;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.person.info.Person;

import java.util.Properties;

public class KafkaAvroProducerV1 {
    public static void main(String[] args) {

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "127.0.0.1:9092"); // Kafka Broker URL
        properties.put("acks", "1");
        properties.put("retries", "10");

        properties.put("key.serializer", StringSerializer.class.getName());
        properties.put("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");

        try (KafkaProducer<String, Person> kafkaProducer = new KafkaProducer<>(properties)) {
            String topic = "person-avro";

            Person.Builder personBuilder = Person.newBuilder()
                    .setName("Aditya")
                    .setAge(21)
                    .setBikeCompany("Royal Enfield")
                    .setBikeInfo("Classic 350 Chrome Bronze")
                    .setLaptop("Apple MacBook M3 pro 14 inches")
                    .setPhone("Samsung Galaxy Z flip series");

            Person person = personBuilder.build();

            ProducerRecord<String, Person> producerRecord = new ProducerRecord<>(topic, person);

            kafkaProducer.send(producerRecord, ((recordMetadata, e) -> {
                if (e == null) {
                    System.out.println("Produced Successfully");
                    System.out.println(recordMetadata.toString());
                } else {
                    e.printStackTrace();
                }
            }));

            kafkaProducer.flush();
        }


    }
}
