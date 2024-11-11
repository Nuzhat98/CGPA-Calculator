package com.example.CGPA_Calculator.Services;

import com.example.CGPA_Calculator.Dtos.CourseRequestModel;
import com.example.CGPA_Calculator.Entities.CourseEntity;
import com.example.CGPA_Calculator.Repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseEntity> addMultipleCourses(List<CourseRequestModel> courseRequestModels) {
        return courseRequestModels.stream().map(eachCourse->{
            CourseEntity newCourseEntity = CourseEntity.builder().courseId(eachCourse.getCourseId()).courseName(eachCourse.getCourseName()).courseCredit(eachCourse.getCourseCredit()).build();
            return courseRepository.save(newCourseEntity);
        }).toList();
    }
}
