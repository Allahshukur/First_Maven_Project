package az.Allahshukur.Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {

    public static Connection connect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String host ="localhost";
        String port = "3306";
        String db = "student_and_teacher_db";
        String userName = "root";
        String password = "12345";
        String conURL = String.format("jdbc:mysql://%s:%s/%s ?serverTimezone=UTC",host,port,db);
        Connection con = DriverManager.getConnection(conURL, userName, password);
        System.out.println("Connected");
        return con;

    }

}
