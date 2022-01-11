package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L,"Priyesh","iec2018048@iiita.ac.in",21, LocalDate.of(2000, Month.MAY,28))
        );
    }
}
