package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .addAnnotatedClass(Course.class)
      .addAnnotatedClass(Review.class)
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // start a transaction
      session.beginTransaction();

      // get the student Mary from database
      int id = 2;
      Student student = session.get(Student.class, id);

      System.out.println("\nLoaded student: " + student);
      System.out.println("Courses: " + student.getCourses());

      // delete student
      System.out.println("\nDeleting student: " + student);
      session.delete(student);

      // commit transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      // add clean up code
      session.close();

      sessionFactory.close();
    }
  }

}
