package com.school.selection.repository;

import com.school.selection.model.AkashAcademyStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkashAcademyStudentRepository extends JpaRepository<AkashAcademyStudent, Integer> {

}
