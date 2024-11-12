package com.example.CGPA_Calculator.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="Students")
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(generator = "SixDigitIdGenerator")
    @GenericGenerator(name="SixDigitIdGenerator",strategy = "com.example.CGPA_Calculator.Others.SixDigitIdGenerator")
    private Long studentId;

    private String studentName;
    private String studentDept;
    private Double studentResult;
    private Integer attemptedCredit;

    @OneToMany(mappedBy = "studentEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudentCourseEntity> studentCourseEntities = new ArrayList<>();
}
