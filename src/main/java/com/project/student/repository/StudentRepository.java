package com.project.student.repository;

import com.project.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Student repository.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findFirstByCourse(String course);
}
