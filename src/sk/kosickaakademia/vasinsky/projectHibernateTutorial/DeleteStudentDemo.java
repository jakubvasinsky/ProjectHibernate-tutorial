package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//THIS IS INSERT ONE CLASS
public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            int studentId = 3;

            session = factory.getCurrentSession();
             session.beginTransaction();
            System.out.println("\n Getting student with id: "+ studentId);
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("\n Deleting student with id: "+ studentId);
        session.delete(myStudent);

            session.getTransaction().commit();

            System.out.println("\n Done!");


        }finally {
            factory.close();
        }


    }
}
