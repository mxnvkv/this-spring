package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
      // create the objects

      Instructor tempInstructor =
        new Instructor("Susan", "Public", "madhu@luv2code.com");

      InstructorDetail tempInstructorDetail =
        new InstructorDetail("http://www.youtube.com", "Video Games");

      // associate the objects
      tempInstructor.setInstructorDetail(tempInstructorDetail);

      // start a transaction
      session.beginTransaction();

      // save the instructor
      //
      // Note: this will also SAVE the details object
      // because of Cascade.ALL
      //
      System.out.println("Saving instructor: " + tempInstructor);
      session.save(tempInstructor);

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
