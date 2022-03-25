package com.school.selection.service;

import com.school.selection.model.School;
import com.school.selection.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;

    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    public School getSchool(int id) {
        return schoolRepository.findById(id).get();
    }

    public void addSchool(School school) {
        schoolRepository.save(school);
    }

    public void updateSchool(School school) {
        schoolRepository.save(school);
    }

    public void deleteSchool(int id) {
        schoolRepository.deleteById(id);
    }
    

}