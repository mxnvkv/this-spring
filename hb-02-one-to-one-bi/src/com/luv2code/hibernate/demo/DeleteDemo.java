package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

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

      // get instructor by primary key / id
      int id = 1;
      Instructor tempInstructor = session.get(Instructor.class, id);

      System.out.println("Found instructor: " + tempInstructor);

      // delete the instructor
      if (tempInstructor != null) {

        System.out.println("Deleting: " + tempInstructor);

        // Note: will also delete associated details object
        // because of CascadeType.ALL
        session.delete(tempInstructor);
      }

      // commit transaction
      session.getTransaction().commit();

      System.out.println("Done!");
    }
    finally {
      sessionFactory.close();
    }
  }

}
