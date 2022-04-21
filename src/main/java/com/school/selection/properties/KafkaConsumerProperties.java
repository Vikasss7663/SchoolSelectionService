package com.school.selection.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("kafka.consumer")
public class KafkaConsumerProperties {

    private String bootstrapServers;
    private String schemaRegistryUrl;
    private String groupId;

}
