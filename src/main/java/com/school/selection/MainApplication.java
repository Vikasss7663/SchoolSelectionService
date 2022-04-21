package com.school.selection;

import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.school.selection.constants.ApplicationsConstants.*;

@SpringBootApplication
@Slf4j
public class MainApplication {

	public static void main(String[] args) {

		SpringApplication.run(MainApplication.class, args);

		/*
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, GROUP_ID);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				io.confluent.kafka.serializers.KafkaAvroDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				io.confluent.kafka.serializers.KafkaAvroDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		props.put(SCHEMA_REGISTRY_URL, SCHEMA_REGISTRY_URL_VAL);

		final Consumer<GenericRecord, GenericRecord> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(TOPIC_NAME));

		try {
			while (true) {
				ConsumerRecords<GenericRecord, GenericRecord> records = consumer.poll(Duration.ofSeconds(1));
				for (ConsumerRecord<GenericRecord, GenericRecord> record : records) {
					log.debug("\n\n\n\n");
					log.debug(record.offset() + " " + record.key() + " " + record.value());
					log.debug("\n\n\n\n");
				}
			}
		} finally {
			consumer.close();
		}
		*/

	}

}
