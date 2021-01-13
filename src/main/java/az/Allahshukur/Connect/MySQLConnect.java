package az.Allahshukur.Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnect {

    public static Connection connect() throws Exception{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String host ="sql2.freemysqlhosting.net";
            String port = "3306";
            String db = "sql2385489";
            String userName = "sql2385489";
            String password = "pQ3!bI2%";
            String conURL = String.format("jdbc:mysql://%s:%s/%s",host,port,db);
            Connection con = DriverManager.getConnection(conURL, userName, password);
            System.out.println("Connected");
            return con;

    }

}
