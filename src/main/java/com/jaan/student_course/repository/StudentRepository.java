package com.jaan.student_course.repository;

import com.jaan.student_course.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}