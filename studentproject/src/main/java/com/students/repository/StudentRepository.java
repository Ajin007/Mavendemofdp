package com.students.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.students.model.Student;

public class StudentRepository {

        // In-memory storage
        private List<Student> students = new ArrayList<>();
        private int idCounter = 1;
    
        // Save a new student
        public Student save(String name, String email, int age, String course) {
            Student s = new Student(idCounter++, name, email, age, course);
            students.add(s);
            return s;
        }
    
        // Get all students
        public List<Student> findAll() {
            return students;
        }
    
        // Find by ID
        public Optional<Student> findById(int id) {
            return students.stream()
                           .filter(s -> s.getId() == id)
                           .findFirst();
        }
    
        // Delete by ID
        public boolean deleteById(int id) {
            return students.removeIf(s -> s.getId() == id);
        }
    
        // Count
        public int count() {
            return students.size();
        }
    }


