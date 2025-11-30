package com.kafka.consumer.service;

import com.kafka.consumer.dto.AnalyticsConsumerDTO;
import com.kafka.consumer.entity.AnalyticsConsumer;
import com.kafka.consumer.repo.ConsumerRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConsumerService {

    private final ConsumerRepo consumerRepo;
    private final ModelMapper modelMapper;

    public void saveConsumerEvent(AnalyticsConsumerDTO analyticsConsumerDTO)
    {
        AnalyticsConsumer analyticsConsumer = modelMapper.map(analyticsConsumerDTO, AnalyticsConsumer.class);
        consumerRepo.save(analyticsConsumer);
    }

}
