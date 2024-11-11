package com.example.CGPA_Calculator.Services;

import com.example.CGPA_Calculator.Dtos.CourseRequestModel;
import com.example.CGPA_Calculator.Entities.CourseEntity;

import java.util.List;

public interface CourseService {

    List<CourseEntity> addMultipleCourses(List<CourseRequestModel> courseRequestModels);
}
