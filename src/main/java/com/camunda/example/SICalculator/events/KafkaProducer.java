package com.camunda.example.SICalculator.events;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    public static final String topic ="mytopic";

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void publishToKafka(String message){
        System.out.println("Message getting Published");

        kafkaTemplate.send(topic,message);
        System.out.println("Message Published");

    }
}
