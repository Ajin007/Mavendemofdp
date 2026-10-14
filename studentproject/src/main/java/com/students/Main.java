package com.students;

import java.util.List;
import java.util.Scanner;

import com.students.model.Student;
import com.students.service.StudentService;

public class Main {

    static StudentService service = new StudentService();
static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Student Management System");

         boolean running = true;

        while (running) {
            printMenu();
            System.out.print("Enter choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> addStudent();
                case "2" -> viewAllStudents();
               
                case "5" -> {
                    System.out.println("\n👋 Goodbye!");
                    running = false;
                }
                default  -> System.out.println("\n❌ Invalid choice! Try again.\n");
            }
        }

        // ── Add Student ───────────────────────────────
        
        
        
    }


static void addStudent() {
    System.out.println("\n── Add New Student ──────────────");
    try {
        System.out.print("Name   : ");
        String name = scanner.nextLine();

        System.out.print("Email  : ");
        String email = scanner.nextLine();

        System.out.print("Age    : ");
        int age = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Course : ");
        String course = scanner.nextLine();

        Student s = service.addStudent(name, email, age, course);
        System.out.println("\n✅ Student added! ID = " + s.getId());

    } catch (NumberFormatException e) {
        System.out.println("❌ Age must be a number!");
    } catch (IllegalArgumentException e) {
        System.out.println("❌ " + e.getMessage());
    }
}

// ── View All ──────────────────────────────────
    static void viewAllStudents() {
        List<Student> list = service.getAllStudents();
        System.out.println("\n── All Students ─────────────────────────────────────────────────────");

        if (list.isEmpty()) {
            System.out.println("  No students found!");
            return;
        }

        System.out.println("┌──────┬──────────────────────┬───────────────────────────┬──────┬─────────────────┐");
        System.out.println("│ ID   │ Name                 │ Email                     │ Age  │ Course          │");
        System.out.println("├──────┼──────────────────────┼───────────────────────────┼──────┼─────────────────┤");
        list.forEach(System.out::println);
        System.out.println("└──────┴──────────────────────┴───────────────────────────┴──────┴─────────────────┘");
        System.out.println("  Total: " + service.getTotalCount() + " student(s)");
    }

        static void printMenu() {
        System.out.println("\n┌─────────────────────────┐");
        System.out.println("│         MENU            │");
        System.out.println("├─────────────────────────┤");
        System.out.println("│  1. Add Student         │");
        System.out.println("│  2. View All Students   │");
        System.out.println("│  3. Find Student by ID  │");
        System.out.println("│  4. Delete Student      │");
        System.out.println("│  5. Exit                │");
        System.out.println("└─────────────────────────┘");
    }


}