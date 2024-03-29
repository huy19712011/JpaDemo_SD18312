package org.example.jpademo_sd18312.service;

import org.example.jpademo_sd18312.dao.StudentDao;
import org.example.jpademo_sd18312.entity.Student;

import java.util.List;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public List<Student> getAllStudents() {
        return studentDao.getStudents();
    }
}
