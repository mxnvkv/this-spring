package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // start a transaction
      session.beginTransaction();

      // get the instructor detail object
      int id = 2;
      InstructorDetail instructorDetail =
        session.get(InstructorDetail.class, id);

      // print the instructor detail
      System.out.println("instructorDetail: " + instructorDetail);

      // print the associated instructor
      System.out.println("the associated instructor: "
        + instructorDetail.getInstructor());

      // commit transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      sessionFactory.close();
    }
  }

}
