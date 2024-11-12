package com.example.CGPA_Calculator.Services;

import com.example.CGPA_Calculator.Dtos.StudentCourseRequestModel;

public interface StudentCourseService {
    StudentCourseRequestModel addGradeToStudent(Long studentId, String courseId, Double courseGrade, Integer earnedCredit);
}
