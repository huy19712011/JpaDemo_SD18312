package org.example.jpademo_sd18312;

import org.example.jpademo_sd18312.dao.StudentDao;
import org.example.jpademo_sd18312.entity.Student;

import java.util.List;

public class App {

    public static void main(String[] args) {

        System.out.println("running...");

        // add
        StudentDao studentDao = new StudentDao();
        Student student = new Student("John", "Doe","JohnDoe@gmail.com");
        studentDao.saveStudent(student);

        // add some more data
        studentDao.saveStudent(new Student("Lionel", "Messi", "lm@gmail.com"));
        studentDao.saveStudent(new Student("Michael", "Jordan", "mj@gmail.com"));
        studentDao.saveStudent(new Student("Thanh", "Binh", "tb@gmail.com"));

        // find by id
         System.out.println(studentDao.getStudentById(4).getLastName());

         // update
        var updateStudent = studentDao.getStudentById(4);
        updateStudent.setLastName("Buon");
        studentDao.updateStudent(updateStudent);

        // get all
        List<Student> students = studentDao.getStudents();
        students.forEach(s -> System.out.println(s.getLastName()));

        // remove
        studentDao.deleteStudent(updateStudent);
        System.out.println("after removing:");
        studentDao.getStudents().forEach(x -> System.out.println(x.getEmail()));
    }
}
