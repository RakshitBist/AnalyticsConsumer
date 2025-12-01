package com.kafka.consumer.kafka;

import com.kafka.consumer.dto.AnalyticsConsumerDTO;
import com.kafka.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ConsumerService consumerService;
    private final ObjectMapper objectMapper = new ObjectMapper();


    @KafkaListener(topics = "analytics_input",groupId = "analytics-consumer",concurrency = "3")
    public void consume(String message)
    {
        AnalyticsConsumerDTO analyticsConsumerDTO = objectMapper.readValue(message,AnalyticsConsumerDTO.class);
        System.out.println("Message Consumed "+ analyticsConsumerDTO);
        consumerService.saveConsumerEvent(analyticsConsumerDTO);
    }

}
