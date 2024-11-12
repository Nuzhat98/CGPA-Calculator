package com.example.CGPA_Calculator.Dtos;

import com.example.CGPA_Calculator.Entities.CourseEntity;
import com.example.CGPA_Calculator.Entities.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class StudentCourseRequestModel {
    @Id
    private Long Id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "studentId")
    private Long studentId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="courseId")
    private String courseId;

    private Double courseGrade;
}
