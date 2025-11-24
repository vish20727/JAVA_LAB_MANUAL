import java.io.*;
import java.util.*;

class Student4 {
    int rollNo;
    String name;
    double marks;

    Student4(int r, String n, double m) {
        rollNo = r;
        name = n;
        marks = m;
    }

    public String toString() {
        return rollNo + "," + name + "," + marks;
    }
}

public class Student_app {
    static ArrayList<Student4> list = new ArrayList<>();

    public static void loadFile() throws Exception {
        File file = new File("students.txt");
        if (!file.exists()) return;

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Student4(
                Integer.parseInt(data[0]),
                data[1],
                Double.parseDouble(data[2])
            ));
        }
        br.close();
    }

    public static void saveFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));
        for (Student4 s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        loadFile();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. View");
            System.out.println("3. Sort by Marks");
            System.out.println("4. Save & Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    System.out.print("Marks: ");
                    double m = sc.nextDouble();

                    list.add(new Student4(r, n, m));
                    break;

                case 2:
                    for (Student4 s : list) {
                        System.out.println(s.rollNo + " " + s.name + " " + s.marks);
                    }
                    break;

                case 3:
                    list.sort((a, b) -> Double.compare(b.marks, a.marks));
                    System.out.println("Sorted by Marks!");
                    break;

                case 4:
                    saveFile();
                    System.out.println("Saved!");
                    return;
            }
        }
    }
}
