package service;
import model.Student;
import java.util.List;
public interface RecordActions{
 boolean addStudent(Student s);
 boolean deleteStudent(int r);
 boolean updateStudentMarks(int r,double m);
 Student searchByRoll(int r);
 List<Student> viewAllStudents();
}