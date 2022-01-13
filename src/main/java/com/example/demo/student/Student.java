package com.example.demo.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

//entity and table indicate connection to database
@Entity
@Table
public class Student {
    //sequence generator for assigning id like 1,2,3 and so on
    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
//@Transient is ignored by mapping framework and the field not mapped to any database column
    @Transient
    private Integer age;

    public Student() {
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public String  toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
