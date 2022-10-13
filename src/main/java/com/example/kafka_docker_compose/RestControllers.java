package com.example.kafka_docker_compose;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/kafka")
@Data
public class RestControllers {


    private final KafkaProducer producer;

    @Autowired
    public RestControllers(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void sendMessageToTopic(@RequestParam("message") String messages){
        log.info("in the method");
        this.producer.sendMessage(messages);
    }
}
