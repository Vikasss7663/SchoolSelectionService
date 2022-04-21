package com.school.selection.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApplicationsConstants {

    public static final String TOPIC_NAME = "Kafka-Example";
    public static final String SCHEMA_REGISTRY_URL = "schema.registry.url";
    public static final String BOOTSTRAP_SERVER = "http://0.0.0.0:9092";
    public static final String GROUP_ID = "school-service";
    public static final String SCHEMA_REGISTRY_URL_VAL = "http://0.0.0.0:8081";

}
