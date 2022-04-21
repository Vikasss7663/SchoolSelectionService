package com.school.selection.config;

import com.school.management.schema.student.StudentEvent;
import com.school.management.schema.student.StudentEventKey;
import com.school.selection.properties.KafkaConsumerProperties;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.school.selection.constants.ApplicationsConstants.SCHEMA_REGISTRY_URL;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    private final KafkaConsumerProperties kafkaConsumerProperties;

    @Bean
    public ConsumerFactory<StudentEventKey, StudentEvent> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConsumerProperties.getBootstrapServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaConsumerProperties.getGroupId());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                io.confluent.kafka.serializers.KafkaAvroDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(SCHEMA_REGISTRY_URL, kafkaConsumerProperties.getSchemaRegistryUrl());
        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, true);
        return new DefaultKafkaConsumerFactory<>(props);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<StudentEventKey, StudentEvent> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<StudentEventKey, StudentEvent>
                factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}
