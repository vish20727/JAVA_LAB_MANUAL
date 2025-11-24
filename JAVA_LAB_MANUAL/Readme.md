NAME : Vishesh Vinshan Saraswat
Roll no : 2401360027
Course : Btceh CSE (ux/ui)

# 📘 Student Record Management System (Java)

A complete console-based Java application for managing student records using:

- **OOP (Inheritance, Abstraction, Polymorphism)**
- **Interfaces & Modular Design**
- **Exception Handling**
- **Multithreading (Loading simulation)**
- **File Handling (Persistent storage)**
- **Collections Framework (List, Map, Sorting, Iterators)**

This project is based on the **Java Lab Manual (KR Mangalam University – 2025)** and covers **Assignment 1 to Assignment 5** combined into one capstone project.

## 🚀 Features

### ✔ Add a Student
- Roll number  
- Name  
- Email  
- Course  
- Marks  
- Auto-grade generation

### ✔ Search, Update, Delete Students

### ✔ Sorting
Sort students by marks (descending).

### ✔ File I/O
Loads student data from `students.txt`, saves on exit.

### ✔ Multithreading
Loading animation during operations.

---

## 📂 Project Structure

```
src/
 ├── model/
 │     ├── Person.java
 │     ├── Student.java
 ├── service/
 │     ├── RecordActions.java
 │     ├── StudentManager.java
 ├── util/
 │     ├── FileUtil.java
 │     ├── Loader.java
 └── app/
       ├── Main.java

students.txt
README.md
```

---

## 🛠️ How to Run

### Step 1: Compile
```
javac -d out $(find . -name "*.java")
```

### Step 2: Run
```
java -cp out app.Main
```

---

## 📦 Storage Format (students.txt)
```
rollNo,name,email,course,marks
101,shelja,SHELJA@mail.com,B.Tech,85.5
102,akshat,AKSHAT@mail.com,M.Tech,91.0
103,tarun,TARUN@mail.com,M.Tech,92.0
```

---
