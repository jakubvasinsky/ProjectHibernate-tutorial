package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//THIS IS INSERT MANY CLASS
public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            System.out.println("\n Creating 3 Student objects...");

            Student tempStudent1 = new Student("Ondrej", "Ondrejovic", "ondrej@ondrejovic.sk");
            Student tempStudent2 = new Student("Fero", "Novak", "fero@novak.sk");
            Student tempStudent3 = new Student("Leo", "Poldov", "leo@poldov.sk");

            session.beginTransaction();

            System.out.println("\n Saving the Students...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();
            System.out.println("\n Done!");

        }finally {
            factory.close();
        }



    }
}
