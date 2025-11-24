import java.util.*;

// Abstract Person class
abstract class Person {
    String name;
    String email;

    abstract void displayInfo();
}

// Student class extending Person
class Student2 extends Person {
    int rollNo;
    String course;
    double marks;
    char grade;

    Student2(String name, String email, int rollNo, String course, double marks) {
        this.name = name;
        this.email = email;
        this.rollNo = rollNo;
        this.course = course;
        this.marks = marks;
        calculateGrade();
    }

    void calculateGrade() {
        if (marks >= 90) grade = 'A';
        else if (marks >= 75) grade = 'B';
        else if (marks >= 60) grade = 'C';
        else grade = 'D';
    }

    @Override
    void displayInfo() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Course: " + course);
        System.out.println("Marks: " + marks);
        System.out.println("--------------------");
    }
}

// Interface
interface RecordActions {
    void addStudent(Student2 s);
    void deleteStudent(int rollNo);
    void updateStudent(int rollNo, double marks);
    void viewAllStudents();
    void searchStudent(int rollNo);
}

// Student Manager implementing interface
class StudentManager implements RecordActions {
    Map<Integer, Student2> map = new HashMap<>();

    public void addStudent(Student2 s) {
        if (map.containsKey(s.rollNo)) {
            System.out.println("Duplicate Roll Number Not Allowed!");
            return;
        }
        map.put(s.rollNo, s);
    }

    public void deleteStudent(int rollNo) {
        if (map.remove(rollNo) != null)
            System.out.println("Student deleted.");
        else
            System.out.println("Student not found.");
    }

    public void updateStudent(int rollNo, double marks) {
        Student2 s = map.get(rollNo);
        if (s != null) {
            s.marks = marks;
            s.calculateGrade();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(int rollNo) {
        if (map.containsKey(rollNo))
            map.get(rollNo).displayInfo();
        else
            System.out.println("Student not found.");
    }

    public void viewAllStudents() {
        for (Student2 s : map.values()) {
            s.displayInfo();
        }
    }
}

public class StudentApp {
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();

        sm.addStudent(new Student2("Aryan", "aryan@mail.com", 101, "B.Tech", 85));
        sm.addStudent(new Student2("Saransh", "saransh@mail.com", 102, "B.Tech", 80));

        System.out.println("All Students:");
        sm.viewAllStudents();
    }
}
