package com.project.student.service;

import com.project.student.model.Student;

import java.util.List;

/**
 * The Student service interface.
 */
public interface StudentService {
    Student add(Student student);
    Student update(Student student, Long id);
    Student getById(Long id);
    void deleteById(Long id);
    List<Student> getAll();
    Student getByCourse(String course);
}
