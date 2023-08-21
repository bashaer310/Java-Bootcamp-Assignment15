package com.example.assignment14.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AddressModel {
    @Id
    private Integer id;

    @NotEmpty(message = "Area must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String area;

    @NotEmpty(message = "Street must not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String street;

    @NotNull(message = "Building Number must not be empty")
    @Positive(message ="Building Number must be a positive number" )
    @Column(columnDefinition = "int UNSIGNED not null")
    private Integer buildingNumber;

    @OneToOne
    @MapsId
    @JsonIgnore //**
    private TeacherModel teacherModel;

}
