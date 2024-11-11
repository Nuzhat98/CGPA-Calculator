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
public class StudentRequestModel {
    @Id
    private Long studentId;

    private String studentName;
    private String studentDept;
    private Double studentResult;
}
