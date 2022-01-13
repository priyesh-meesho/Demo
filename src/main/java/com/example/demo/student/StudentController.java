package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//rest controller annotation makes this class able to serve rest endpoints
@RestController
@RequestMapping(path = "api/v1/student")
//this class contains all the API's(API Layer)
//API layer is the topmost layer
public class StudentController {

    private final StudentService studentService;

    @Autowired
    //annotation for injecting bean of StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping (path = "{studentId}")
    public void deleteStudent(
            @PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping (path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId,name,email);
    }
}
