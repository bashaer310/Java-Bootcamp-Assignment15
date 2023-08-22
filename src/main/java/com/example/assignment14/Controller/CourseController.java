package com.example.assignment14.Controller;


import com.example.assignment14.Api.ApiResponse;
import com.example.assignment14.Model.CourseModel;
import com.example.assignment14.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/course")
@RequiredArgsConstructor
public class CourseController {


    private final CourseService courseService;


    @GetMapping("/get")
    public ResponseEntity getCourses(){
        return  ResponseEntity.status(200).body(courseService.getCourses());
    }


    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid CourseModel course){
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@RequestBody @Valid CourseModel course, @PathVariable Integer id) {
        courseService.updateCourse(course,id);
        return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));
    }

    @PutMapping("/{teacherId}/assign/{courseId}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacherId,@PathVariable Integer courseId){

        courseService.assignTeacherToCourse(teacherId, courseId);
        return ResponseEntity.status(200).body(new ApiResponse("Assign done"));
    }

    @GetMapping("getTeacherNameByCourseId/{courseId}")
    public ResponseEntity getTeacherNameByCourseId(@PathVariable Integer courseId){
        return ResponseEntity.status(200).body(courseService.getTeacherNameByCourseId(courseId));
    }
}

