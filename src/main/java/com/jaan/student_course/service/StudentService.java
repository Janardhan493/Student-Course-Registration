package com.jaan.student_course.service;

import com.jaan.student_course.entity.Student;
import com.jaan.student_course.repository.StudentRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);

        existingStudent.setStudentName(updatedStudent.getStudentName());
        existingStudent.setCourseName(updatedStudent.getCourseName());
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAge(updatedStudent.getAge());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}