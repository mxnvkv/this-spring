package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .addAnnotatedClass(Course.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // start a transaction
      session.beginTransaction();

      // get a course
      int theId = 10;
      Course tempCourse = session.get(Course.class, theId);

      // delete a course
      System.out.println("Deleting course: " + tempCourse);

      session.delete(tempCourse);

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