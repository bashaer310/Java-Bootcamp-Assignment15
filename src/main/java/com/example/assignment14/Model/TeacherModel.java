package com.example.assignment14.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TeacherModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull(message = "Age must not be empty")
    @Positive(message ="Age must be a positive number" )
    @Column(columnDefinition = "int UNSIGNED not null")
    private Integer age;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be a valid format")
    @Column(columnDefinition = "varchar(30) unique not null CHECK(email REGEXP '([a-zA-Z0-9]{6,})(@)([a-zA-Z]{6,})(\\.)([a-zA-Z]{2,})')")
    private String email;

    @NotNull(message = "Salary  must not be empty")
    @Positive(message ="Salary must be a positive number" )
    @Column(columnDefinition = "int UNSIGNED not null")
    private Integer salary;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacherModel")
    @PrimaryKeyJoinColumn
    private AddressModel addressModel;


    @OneToMany(cascade = CascadeType.ALL, mappedBy ="teacherModel")
    private Set<CourseModel> courseModel;

}
