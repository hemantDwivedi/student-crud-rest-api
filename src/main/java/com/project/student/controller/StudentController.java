package com.project.student.controller;

import com.project.student.model.Student;
import com.project.student.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Student controller.
 */
@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;

    /**
     * Add student entity.
     *
     * @param student the student
     * @return the student entity
     */
    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student){
        return new ResponseEntity<>(studentService.add(student), HttpStatus.CREATED);
    }

    /**
     * Update Student entity.
     *
     * @param student the student
     * @param id the id
     * @return the update student entity
     */
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student,
                                       @PathVariable Long id){
        return ResponseEntity.ok(studentService.update(student, id));
    }

    /**
     * Get by id Student entity.
     *
     * @param id the id
     * @return the student entity
     */
    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getById(id));
    }

    /**
     * Get student entity by course.
     *
     * @param course the course
     * @return the student by course
     */
    @GetMapping("/course")
    public ResponseEntity<Student> getByCourse(@RequestParam(name = "course") String course){
        return ResponseEntity.ok(studentService.getByCourse(course));
    }
    /**
     * Get all student entity.
     *
     * @return the List of student entity
     */
    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    /**
     * Delete by id student entity.
     *
     * @param id the id
     * @return the String with message: "student deleted with id : {given id}"
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        studentService.deleteById(id);
        return ResponseEntity.ok("student deleted with id : " + id);
    }
}
