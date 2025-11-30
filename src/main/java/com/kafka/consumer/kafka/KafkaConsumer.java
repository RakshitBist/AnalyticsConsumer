package com.kafka.consumer.kafka;

import com.kafka.consumer.dto.AnalyticsConsumerDTO;
import com.kafka.consumer.service.ConsumerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final ConsumerService consumerService;


    @KafkaListener(topics = "analytics_service",groupId = "analytics-consumer",concurrency = "3")
    public void consume(AnalyticsConsumerDTO analyticsConsumerDTO)
    {
        System.out.println("Message Consumed "+ analyticsConsumerDTO);
        consumerService.saveConsumerEvent(analyticsConsumerDTO);
    }

}
