package com.example.kafka_docker_compose;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@Slf4j
@RequestMapping("/r")
//@Data
public class RestControllers {


    private final KafkaProducer producer;

    @Autowired
    public RestControllers(KafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/publish")
    public void msjToTopic(@RequestParam("message") String messages){
        //log.info("in the method");
        this.producer.sendMessage(messages);
    }
}
