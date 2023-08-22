package com.example.assignment14.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @ManyToOne
    @JoinColumn(name = "teacherModel_id", referencedColumnName = "id")
    @JsonIgnore
    private TeacherModel teacherModel;
}
