package com.school.selection.service;

import com.school.selection.model.AkashAcademyStudent;
import com.school.selection.repository.AkashAcademyStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AkashAcademyStudentService {

    private final AkashAcademyStudentRepository repository;

    public List<AkashAcademyStudent> getStudents() {
        return repository.findAll();
    }

    public AkashAcademyStudent addStudent(AkashAcademyStudent student) {
        return repository.save(student);
    }

}