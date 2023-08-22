package com.example.assignment14.Service;

import com.example.assignment14.Api.ApiException;
import com.example.assignment14.Model.CourseModel;
import com.example.assignment14.Model.TeacherModel;
import com.example.assignment14.Repository.CourseRepository;
import com.example.assignment14.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<CourseModel> getCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(CourseModel course){
        courseRepository.save(course);
    }

    public void updateCourse(CourseModel course, Integer id){
        CourseModel oldCourse=courseRepository.findCourseModelById(id);
        if (oldCourse==null)
            throw new ApiException("Id not found");

        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }


    public void deleteCourse(Integer id){
        CourseModel course=courseRepository.findCourseModelById(id);
        if (course==null)
            throw new ApiException("Id not found");

        courseRepository.delete(course);
    }

    public void assignTeacherToCourse(Integer teacherId,Integer courseId)
    {
        CourseModel course=courseRepository.findCourseModelById(courseId);
        TeacherModel teacher=teacherRepository.findTeacherModelById(teacherId);

        if (course==null || teacher==null)
            throw new ApiException("can't assign");

        course.setTeacherModel(teacher);
        courseRepository.save(course);
    }

    public String getTeacherNameByCourseId(Integer courseId)
    {
        CourseModel course=courseRepository.findCourseModelById(courseId);

        TeacherModel teacher=teacherRepository.findTeacherModelByCourseModelContains(course);

        if (course==null || teacher==null)
            throw new ApiException("Not found");

        return(teacher.getName());
    }




}
