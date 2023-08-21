package com.example.assignment14.Service;

import com.example.assignment14.Api.ApiException;
import com.example.assignment14.Model.TeacherModel;
import com.example.assignment14.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<TeacherModel> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(TeacherModel teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, TeacherModel teacher){
        TeacherModel oldTeacher=teacherRepository.findTeacherModelById(id);
        if(oldTeacher==null)
            throw new ApiException("Id not found");
        oldTeacher=teacher;
        oldTeacher.setId(id);
        teacherRepository.save(oldTeacher);
    }
    public void deleteTeacher(Integer id){
        TeacherModel teacher=teacherRepository.findTeacherModelById(id);
        if(teacher==null)
            throw new ApiException("Id not found");
        teacherRepository.delete(teacher);
    }
}
