package util;
import java.util.*; import java.io.*; import model.Student;
public class FileUtil{
 public static List<Student> readStudents(String p)throws IOException{
  List<Student>l=new ArrayList<>(); File f=new File(p); if(!f.exists())return l;
  BufferedReader br=new BufferedReader(new FileReader(f)); String line;
  while((line=br.readLine())!=null) l.add(Student.fromCSV(line)); br.close(); return l;
 }
 public static void writeStudents(String p,List<Student>l)throws IOException{
  BufferedWriter bw=new BufferedWriter(new FileWriter(p));
  for(Student s:l) bw.write(s.toString()+"\n"); bw.close();
 }
}