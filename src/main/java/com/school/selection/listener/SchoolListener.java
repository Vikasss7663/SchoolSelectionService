package com.school.selection.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

import static com.school.selection.constants.ApplicationsConstants.TOPIC_NAME;

@Slf4j
public class SchoolListener {

    @KafkaListener(topics = TOPIC_NAME)
    public void listen(String message) {
        log.debug("\n\n\nReceived Message: " +  message + "\n\n\n");
    }

}
