package com.example.SpringBootTestDemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column(name ="ID")
    private Integer id;


    @Column(name ="NAME")
    @NotBlank
    private String name;

    @Column(name ="ADDRESS")
    private String address;

    @Column(name ="ROLLNO")
    private String rollNo;


}
