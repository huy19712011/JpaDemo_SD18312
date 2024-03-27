package org.example.jpademo_sd18312.dao;

import org.example.jpademo_sd18312.entity.Student;
import org.example.jpademo_sd18312.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public Student getStudentById(int id) {
        // JDBC: sql, statement, resultSet
        // JPA: Session, Transaction
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            Student student = session.find(Student.class, id);

            transaction.commit();

            return student;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateStudent(Student student) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            transaction = session.beginTransaction();

            session.merge(student); // save or update

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteStudent(Student student) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.remove(student);
            transaction.commit();
        } catch (Exception e) {

            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Student> getStudents() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()){

            return session.createQuery("from Student", Student.class).list();
        }
    }
}
