package com.school.selection.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class JhunjhunuAcademyStudent {

    @Id
    @Column(nullable = false)
    private int studentId;
    @Column(nullable = false)
    private String studentName;
    private int studentSemester;
    private int studentYear;

}