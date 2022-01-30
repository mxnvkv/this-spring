package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      int studentId = 1;

      // get a new session and start transaction
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      // retrieve student base on the id: primary key
      System.out.println("\nGetting student with id: " + studentId);

      Student retrievedStudent = session.get(Student.class, studentId);

      // delete the student
      // System.out.println("Deleting student: " + retrievedStudent);
      // session.delete(retrievedStudent);

      // delete student id = 2
      System.out.println("Deleting student id = 2");
      session.createQuery("delete from Student where id=2")
        .executeUpdate();

      // commit transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      sessionFactory.close();
    }
  }

}
