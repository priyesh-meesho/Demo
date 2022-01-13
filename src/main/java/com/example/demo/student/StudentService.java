package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
//service layer-this class contains all the business logic
//it is between the API layer and Database Layer
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    //annotation for injecting bean of StudentRepository
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //many database manipulation methods are available for studentRepository since it extends JPA repository
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("student with id "+ studentId +" does not exist");
        }
        studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(()->new IllegalStateException("student with id "+ studentId +" does not exist"));
        if(name != null && name.length()>0 && !Objects.equals(student.getName(),name)) {
            student.setName(name);
        }
        if(email != null && email.length()>0 && !Objects.equals(student.getEmail(),email)) {

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email taken1");
            }
            student.setEmail(email);
        }
    }
}
