package com.api.demo.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.api.demo.model.Role;
import com.api.demo.model.Student;
import com.api.demo.repository.StudentRepository;

// @Configuration
public class DatabaseSeeder implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;

    @Autowired
    public DatabaseSeeder(PasswordEncoder passwordEncoder, StudentRepository studentRepository) {
        this.passwordEncoder = passwordEncoder;
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Role studentRole = new Role();
        studentRole.setId((long) 1);
        studentRole.setRole("STUDENT");
        Student jhone = new Student();
        jhone.setId((long) 1);
        jhone.setFirstName("Jhone");
        jhone.setLastName("Mark");
        jhone.setEmail("jhone@quadrate.lk");
        jhone.setPassword(passwordEncoder.encode("12345678"));
        jhone.addRole(studentRole);
        studentRepository.save(jhone);
    }

}
