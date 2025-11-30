package com.kafka.consumer.repo;

import com.kafka.consumer.entity.AnalyticsConsumer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumerRepo extends JpaRepository<AnalyticsConsumer, Long> {
}
