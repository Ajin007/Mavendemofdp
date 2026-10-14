package com.students.service;

import java.util.List;
import java.util.Optional;

import com.students.model.Student;
import com.students.repository.StudentRepository;

public class StudentService {

    private StudentRepository repo = new StudentRepository();

    // Add student with validation
    public Student addStudent(String name, String email, int age, String course) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address!");
        }
        if (age < 15 || age > 60) {
            throw new IllegalArgumentException("Age must be between 15 and 60!");
        }
        return repo.save(name.trim(), email.trim(), age, course.trim());
    }

    // Get all students
    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    // Find by ID
    public Optional<Student> findById(int id) {
        return repo.findById(id);
    }

    // Delete student
    public boolean deleteStudent(int id) {
        return repo.deleteById(id);
    }

    // Total count
    public int getTotalCount() {
        return repo.count();
    }
}
