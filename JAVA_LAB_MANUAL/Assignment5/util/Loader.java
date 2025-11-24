package util;
public class Loader implements Runnable{
 private String msg;
 public Loader(String m){msg=m;}
 public void run(){
  System.out.print(msg);
  try{for(int i=0;i<5;i++){Thread.sleep(200);System.out.print('.');}}catch(Exception e){}
  System.out.println();
 }
}