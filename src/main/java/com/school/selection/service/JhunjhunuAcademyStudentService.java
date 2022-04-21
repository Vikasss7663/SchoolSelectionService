package com.school.selection.service;

import com.school.selection.model.JhunjhunuAcademyStudent;
import com.school.selection.repository.JhunjhunuAcademyStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JhunjhunuAcademyStudentService {

    private final JhunjhunuAcademyStudentRepository repository;

    public List<JhunjhunuAcademyStudent> getStudents() {
        return repository.findAll();
    }

    public JhunjhunuAcademyStudent addStudent(JhunjhunuAcademyStudent student) {
        return repository.save(student);
    }

}