package org.example.jpademo_sd18312.service;

import org.example.jpademo_sd18312.dao.StudentDao;
import org.example.jpademo_sd18312.entity.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public List<Student> getAllStudents() {
        return studentDao.getStudents();
    }

    public void addStudent(Student student) {
        studentDao.saveStudent(student);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public void deleteStudent(String studentId) {
        studentDao.deleteStudent(studentDao.getStudentById(Integer.parseInt(studentId)));
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }
}
