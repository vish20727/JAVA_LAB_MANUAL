package model;
public class Student extends Person implements Comparable<Student>{
 private int rollNo;
 private String course;
 private double marks;
 private char grade;
 public Student(int r,String n,String e,String c,double m){
   super(n,e); rollNo=r; course=c; marks=m; calc();
 }
 public int getRollNo(){return rollNo;}
 public double getMarks(){return marks;}
 public void setMarks(double m){marks=m;calc();}
 private void calc(){
   grade = marks>=90?'A':marks>=75?'B':marks>=60?'C':'D';
 }
 public void displayInfo(){
   System.out.println(rollNo+" "+name+" "+email+" "+course+" "+marks+" "+grade);
 }
 public String toString(){return rollNo+","+name+","+email+","+course+","+marks;}
 public static Student fromCSV(String l){
   String[]p=l.split(",");return new Student(Integer.parseInt(p[0]),p[1],p[2],p[3],Double.parseDouble(p[4]));
 }
 public int compareTo(Student o){return Double.compare(o.marks,this.marks);}
}