package sk.kosickaakademia.vasinsky.projectHibernateTutorial;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";

        try{
            System.out.println("\n Connecting to Database ...");

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, password);

            System.out.println("\n Connection Successful");


        }
        catch (Exception exc){
            exc.printStackTrace();
        }
    }
}
