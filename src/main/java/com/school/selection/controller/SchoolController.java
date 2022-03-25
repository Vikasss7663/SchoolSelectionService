package com.school.selection.controller;

import com.school.selection.model.School;
import com.school.selection.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService schoolService;

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

}
