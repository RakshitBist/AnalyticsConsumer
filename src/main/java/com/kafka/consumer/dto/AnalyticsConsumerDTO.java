package com.kafka.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnalyticsConsumerDTO {

    private String userId;
    private String userName;
    private String appId;
    private String eventType;
    private String deviceType; // mobile/desktop
    private String browser;
    private Long timestamp;

}
