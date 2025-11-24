import java.util.*;

// Custom Exception
class StudentNotFoundException extends Exception {
    StudentNotFoundException(String msg) {
        super(msg);
    }
}

// Loader thread
class Loader implements Runnable {
    public void run() {
        System.out.print("Loading");
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(300);
                System.out.print(".");
            }
        } catch (Exception e) {}
        System.out.println();
    }
}

public class Student_app {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Roll No (Integer): ");
            Integer roll = sc.nextInt();

            sc.nextLine();
            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            System.out.print("Enter Marks: ");
            Double marks = sc.nextDouble();

            if (marks < 0 || marks > 100)
                throw new Exception("Invalid marks range!");

            Thread t = new Thread(new Loader());
            t.start();
            t.join();

            System.out.println("Roll No: " + roll);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("Course: " + course);
            System.out.println("Marks: " + marks);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Program execution completed.");
        }
    }
}
