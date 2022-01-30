package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

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

      // find out the student's id: primary key
      System.out.println("Saved student. Generated id: " + studentId);

      // get a new session and start transaction
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      // retrieve student base on the id: primary key
      System.out.println("\nGetting student with id: " + studentId);

      Student retrievedStudent = session.get(Student.class, studentId);

      System.out.println("Updating student...");
      retrievedStudent.setFirstName("Scooby");

      // commit transaction
      session.getTransaction().commit();

      // NEW CODE
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      // update email for all students
      System.out.println("Update email for all students");

      session.createQuery("update Student set email='foo@gmail.com'")
        .executeUpdate();

      // commit the transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      sessionFactory.close();
    }
  }

}
