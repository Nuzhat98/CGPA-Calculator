package com.example.CGPA_Calculator.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@Table(name="Courses")
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseEntity {
    @Id
    private String courseId;
    private String courseName;
    private Integer courseCredit;
}
