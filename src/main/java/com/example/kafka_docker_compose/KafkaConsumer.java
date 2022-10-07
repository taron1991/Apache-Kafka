package com.example.kafka_docker_compose;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test_topic",groupId = "group_id")
    public void consumeMessage(String message){
        System.out.println(message);
    }

}
