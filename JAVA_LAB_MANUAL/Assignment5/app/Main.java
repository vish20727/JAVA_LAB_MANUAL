package app;
import model.Student;
import service.StudentManager;
import util.Loader;
import java.util.*;
import java.io.IOException;
public class Main {
    private static final String DATA_FILE = "students.txt";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StudentManager manager=new StudentManager();
        try{ manager.loadFromFile(DATA_FILE);}catch(Exception e){}
        while(true){
            System.out.println("1.Add Student ");
            System.out.println("2.View All ");
            System.out.println("3.Search by Roll No");
            System.out.println("4.Delete by Roll No");
            System.out.println("5.View All Sorted by Marks Desc");
            System.out.println("6.Save & Exit");
            System.out.println("Enter choice: ");
            int c=Integer.parseInt(sc.nextLine());
            try{
                if(c==1){
                    System.out.println("Roll: ");int r=Integer.parseInt(sc.nextLine());
                    System.out.println("Name: ");String n=sc.nextLine();
                    System.out.println("Email: ");String e=sc.nextLine();
                    System.out.println("Course: ");String co=sc.nextLine();
                    System.out.println("Marks: ");double m=Double.parseDouble(sc.nextLine());
                    Thread t=new Thread(new Loader("Adding"));t.start();t.join();
                    manager.addStudent(new Student(r,n,e,co,m));
                }else if(c==2){
                    for(Student s:manager.viewAllStudents()) s.displayInfo();
                }else if(c==3){
                    System.out.println("Roll: ");int r=Integer.parseInt(sc.nextLine());
                    Student s=manager.searchByRoll(r);
                    if(s!=null)s.displayInfo(); else System.out.println("Not found");
                }else if(c==4){
                    System.out.println("Roll: ");int r=Integer.parseInt(sc.nextLine());
                    manager.deleteStudent(r);
                }else if(c==5){
                    for(Student s:manager.getSortedByMarksDesc()) s.displayInfo();
                }else if(c==6){
                    Thread t=new Thread(new Loader("Saving"));t.start();t.join();
                    manager.saveToFile(DATA_FILE); return;
                }
            }catch(Exception ex){System.out.println("Error");}
        }
    }
}