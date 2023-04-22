package com.project.student.service.impl;

import com.project.student.exception.ResourceNotFoundException;
import com.project.student.model.Student;
import com.project.student.repository.StudentRepository;
import com.project.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Student service implementation class.
 */
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    @Override
    public Student add(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student update(Student student, Long id) {
        Student student1 = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found with id : " + id)
        );
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setCourse(student.getCourse());
        student1.setCollege(student.getCollege());
        student1.setSession(student.getSession());
        studentRepository.save(student1);
        return student1;
    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found with id : " + id)
        );
    }

    @Override
    public void deleteById(Long id) {
        Student student1 = studentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Student not found with id : " + id)
        );
        studentRepository.delete(student1);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getByCourse(String course) {
        return studentRepository.findFirstByCourse(course);
    }
}
