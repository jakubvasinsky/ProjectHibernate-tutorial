package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import Entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{

            session.beginTransaction();
List<Student> theStudents = session.createQuery("from Student").list();

            displayStudents(theStudents);


            theStudents = session.createQuery("from Student s where s.lastName = 'Novak'").list();
            System.out.println("\nThe students whose last name is Novak");
            displayStudents(theStudents);

            System.out.println("\nThe students whose last name is Novak or first name is Jakub");
            theStudents =
                    session.createQuery("from Student s where s.lastName = 'Novak' or s.firstName= 'Jakub'").list();
            displayStudents(theStudents);


            System.out.println("\n The students whose email ends with poldov");
            theStudents = session.createQuery("from Student s where s.email LIKE '%poldov.sk' ").list();
            displayStudents(theStudents);

            session.getTransaction().commit();
            System.out.println("\n Done!");

        }finally {
            factory.close();
        }


    }

    private static void displayStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents){
            System.out.println(tempStudent);
        }
    }
}
