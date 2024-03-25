package org.example.jpademo_sd18312;

import org.example.jpademo_sd18312.dao.StudentDao;
import org.example.jpademo_sd18312.entity.Student;

import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println("running...");
        StudentDao studentDao = new StudentDao();
        Student student = new Student("John", "Doe","JohnDoe@gmail.com");
        studentDao.saveStudent(student);

        List<Student> students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getEmail()));
    }
}
