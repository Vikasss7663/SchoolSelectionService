package com.school.selection.controller;

import com.school.selection.model.School;
import com.school.selection.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static com.school.selection.constants.ApplicationsConstants.TOPIC_NAME;


@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping
    public List<School> getSchools() {
        return schoolService.getSchools();
    }

    @GetMapping(value = "{id}")
    public School getSchool(@PathVariable int id) {
        return schoolService.getSchool(id);
    }

    @PostMapping
    public void addSchool(@RequestBody School school) {
        schoolService.addSchool(school);
    }

    @PutMapping
    public void updateSchool(@RequestBody School school) {
        schoolService.addSchool(school);
    }

    @DeleteMapping(value = "{id}")
    public void deleteSchool(@PathVariable int id) {
        schoolService.deleteSchool(id);
    }

    @KafkaListener(topics = TOPIC_NAME)
    public void listen(String message) {
        logger.debug("\n\n\nReceived Message: " +  message + "\n\n\n");
    }

}
