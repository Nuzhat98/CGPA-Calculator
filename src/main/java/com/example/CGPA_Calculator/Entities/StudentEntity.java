package com.example.CGPA_Calculator.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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

}
