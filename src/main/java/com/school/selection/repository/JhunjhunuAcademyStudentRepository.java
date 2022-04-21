package com.school.selection.repository;

import com.school.selection.model.AkashAcademyStudent;
import com.school.selection.model.JhunjhunuAcademyStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JhunjhunuAcademyStudentRepository extends JpaRepository<JhunjhunuAcademyStudent, Integer> {

}
