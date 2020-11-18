package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//THIS IS INSERT ONE CLASS
public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("\n Creating a new Student object...");

            Student tempStudent = new Student("Jakub", "Vašinský", "jakub.vasinsky@kosickaakademia.sk");

            session.beginTransaction();

            System.out.println("\n Saving the Student...");
            session.save(tempStudent);

            session.getTransaction().commit();
            System.out.println("\n Done!");

        }finally {
            factory.close();
        }


    }
}
