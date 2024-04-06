package com.example.library.demo.repository;

import com.example.library.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    Optional<Student> findByUsn(String usn);
    Optional<List<Student>> findAllByName(String name);
}
