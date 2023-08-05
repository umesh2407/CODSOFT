//TASK-03 STUDENT MANAGEMENT SYSTEM

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void addStudent() {
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Enter grade: ");
        String grade = sc.nextLine();
        System.out.println("-----------------------------------------------------------------");
        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully.....");
    }

    public void removeStudent() {
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Enter roll number of student to remove: ");
        int rollToRemove = Integer.parseInt(sc.nextLine());

        students.removeIf(student -> student.getRollNumber() == rollToRemove);
        System.out.println("Student removed successfully.......");
    }

    public void searchStudent() {
        System.out.println("-----------------------------------------------------------------");
        System.out.print("Enter roll number of student to search: ");
        int rollToSearch = Integer.parseInt(sc.nextLine());

        for (Student student : students) {
            if (student.getRollNumber() == rollToSearch) {
                System.out.println("Student has been found: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        System.out.println("-----------------------------------------------------------------");
        System.out.println("All students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void closeScanner() {
        sc.close();
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1) Add Student");
            System.out.println("2) Remove Student");
            System.out.println("3) Search Student");
            System.out.println("4) Display All Students");

            System.out.println("5) Exit");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.print("Select any one option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    system.addStudent();
                    break;
                case 2:
                    system.removeStudent();
                    break;
                case 3:
                    system.searchStudent();
                    break;
                case 4:
                    system.displayAllStudents();
                    break;
                case 5:
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~ Exiting ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    system.closeScanner();
                    System.exit(0);
                default:
                    System.out.println("******************** Invalid choice ********************");
            }
        }
    }
}
