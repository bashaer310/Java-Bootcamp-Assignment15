package com.example.assignment14.Repository;

import com.example.assignment14.Model.TeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel,Integer> {
    TeacherModel findTeacherModelById(Integer id);
}
