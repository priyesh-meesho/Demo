package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//represents the database layer
//this interface responsible for data access
@Repository

//JpaRepository<T,v> is a java generic
//T->typeof object we want to work with
//v->the type of id(in student) by which to identify the object
public interface StudentRepository extends JpaRepository<Student,Long> {
//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
