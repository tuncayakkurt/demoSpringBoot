package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student("Mariam", "mari@gmail", LocalDate.of(2000, 8, 5));
            Student alex = new Student("Alex", "alex@gmail", LocalDate.of(2001, 9, 6));
            repository.saveAll(List.of(mariam, alex));
        };
    }
}
