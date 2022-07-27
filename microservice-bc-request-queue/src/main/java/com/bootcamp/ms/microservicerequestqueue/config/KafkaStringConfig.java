package com.bootcamp.ms.microservicerequestqueue.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import com.bootcamp.ms.commons.entity.RequestQueueBc;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaStringConfig {

    public ProducerFactory<String, RequestQueueBc> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean(name = "kafkaStringTemplate")
    public KafkaTemplate<String, RequestQueueBc> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
