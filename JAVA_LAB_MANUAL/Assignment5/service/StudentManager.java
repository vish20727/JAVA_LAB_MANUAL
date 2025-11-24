package service;
import java.util.*; import java.io.*; import model.Student; import util.FileUtil;
public class StudentManager implements RecordActions{
 private Map<Integer,Student> map=new HashMap<>();
 public void loadFromFile(String p)throws IOException{
   for(Student s:FileUtil.readStudents(p)) map.put(s.getRollNo(),s);
 }
 public void saveToFile(String p)throws IOException{
   FileUtil.writeStudents(p,new ArrayList<>(map.values()));
 }
 public boolean addStudent(Student s){ if(map.containsKey(s.getRollNo()))return false; map.put(s.getRollNo(),s);return true;}
 public boolean deleteStudent(int r){return map.remove(r)!=null;}
 public boolean updateStudentMarks(int r,double m){Student s=map.get(r);if(s==null)return false;s.setMarks(m);return true;}
 public Student searchByRoll(int r){return map.get(r);}
 public List<Student> viewAllStudents(){return new ArrayList<>(map.values());}
 public List<Student> getSortedByMarksDesc(){List<Student>l=viewAllStudents();Collections.sort(l);return l;}
}