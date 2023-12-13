package com.example.lab4_part1.Repositories;

import com.example.lab4_part1.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
