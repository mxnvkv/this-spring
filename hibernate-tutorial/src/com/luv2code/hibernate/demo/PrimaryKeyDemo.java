package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // create 3 student objects
      System.out.println("Creating new student object...");
      Student student1 = new Student("John", "Doe", "john@luv2code.com");
      Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
      Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");

      // start a transaction
      session.beginTransaction();

      // save the student object
      System.out.println("Saving the students...");
      session.save(student1);
      session.save(student2);
      session.save(student3);

      // commit transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      sessionFactory.close();
    }
  }

}
