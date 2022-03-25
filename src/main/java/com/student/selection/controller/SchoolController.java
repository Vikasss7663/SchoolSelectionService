package com.student.selection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static com.student.selection.constants.ApplicationsConstants.SCHOOL_NAME_1;
import static com.student.selection.constants.ApplicationsConstants.SCHOOL_NAME_2;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @GetMapping
    public List<String> getSchools() {
        return Arrays.asList(SCHOOL_NAME_1, SCHOOL_NAME_2);
    }

}
