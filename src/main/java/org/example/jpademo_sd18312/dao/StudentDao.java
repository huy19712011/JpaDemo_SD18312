package org.example.jpademo_sd18312.dao;

import org.example.jpademo_sd18312.entity.Student;
import org.example.jpademo_sd18312.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class StudentDao {

    public void saveStudent(Student student) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            session.beginTransaction();
            // code here...
            session.persist(student);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.createQuery("from Student", Student.class).list();
        }
    }
}
