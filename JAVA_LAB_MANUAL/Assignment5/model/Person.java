package model;
public abstract class Person {
    protected String name,email;
    public Person(){}
    public Person(String n,String e){name=n;email=e;}
    public abstract void displayInfo();
}