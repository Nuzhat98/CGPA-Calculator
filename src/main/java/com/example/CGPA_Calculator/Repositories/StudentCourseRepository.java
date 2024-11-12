package com.example.CGPA_Calculator.Repositories;

import com.example.CGPA_Calculator.Entities.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourseEntity,Long> {
}
