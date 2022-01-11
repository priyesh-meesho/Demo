package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.MAY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
                Student priyesh = new Student(
                        "Priyesh",
                        "iec2018048@iiita.ac.in",
                        LocalDate.of(2000, MAY,28)
                );
                Student raj = new Student(
                        "Raj",
                        "iec2018050@iiita.ac.in",
                        LocalDate.of(2001, MAY,28)
                );

                repository.saveAll(List.of(priyesh,raj));
        };
    }
}
