package com.example.CGPA_Calculator.Dtos;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CourseRequestModel {
    @Id
    private String courseId;
    private String courseName;
    private Integer courseCredit;
}
