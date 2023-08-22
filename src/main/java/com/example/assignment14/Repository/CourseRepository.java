package com.example.assignment14.Repository;


import com.example.assignment14.Model.CourseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseModel,Integer> {
    CourseModel findCourseModelById(Integer id);
}
