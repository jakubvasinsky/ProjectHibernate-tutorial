package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//THIS IS INSERT ONE CLASS
public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int studentId = 1;

            session = factory.getCurrentSession();
             session.beginTransaction();
            System.out.println("\n Getting student with id: "+ studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Updating student... ");
            myStudent.setFirstName("Jakub");

            session.getTransaction().commit();
            System.out.println("\n Done!");

            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Updating email for all students... ");
            session.createQuery("update Student set email='test@itsovy.sk'").executeUpdate();

            session.getTransaction().commit();

        }finally {
            factory.close();
        }


    }
}
