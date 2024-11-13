package com.example.CGPA_Calculator.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class SampleGradeRequestModel {
    private String courseId;
    private Integer expCredit;
    private Double expGrade;
}
