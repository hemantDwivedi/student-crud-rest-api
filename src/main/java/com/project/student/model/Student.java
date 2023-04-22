package com.project.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Student entity/model
 */
@Entity
@Table(name = "tbl_students")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String course;
    private String college;
    private String session;
}
