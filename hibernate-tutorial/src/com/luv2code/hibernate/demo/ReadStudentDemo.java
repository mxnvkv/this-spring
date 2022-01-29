package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // create a student object
      System.out.println("Creating new student object...");
      Student student = new Student("Daffy", "Duck", "paul@luv2code.com");

      // start a transaction
      session.beginTransaction();

      // save the student object
      System.out.println("Saving the student...");
      System.out.println(student);
      session.save(student);

      // commit transaction
      session.getTransaction().commit();

      // MY NEW CODE

      // find out the student's id: primary key
      System.out.println("Saved student. Generated id: " + student.getId());

      // get a new session and start transaction
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      // retrieve student base on the id: primary key
      System.out.println("\nGetting student with id: " + student.getId());

      Student retrievedStudent = session.get(Student.class, student.getId());

      System.out.println("Get complete: " + retrievedStudent);

      // commit transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      sessionFactory.close();
    }
  }

}
