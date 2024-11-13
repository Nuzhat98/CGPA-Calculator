package com.example.CGPA_Calculator.Services;

import com.example.CGPA_Calculator.Dtos.SampleGradeRequestModel;
import com.example.CGPA_Calculator.Dtos.StudentCourseRequestModel;

import java.util.List;

public interface StudentCourseService {
    StudentCourseRequestModel addGradeToStudent(Long studentId, String courseId, Double courseGrade, Integer earnedCredit);

    Double testGrade(Long studentId, List<SampleGradeRequestModel> sampleGradeRequestModels);
}
