package az.Allahshukur.repository;

import az.Allahshukur.Connect.MySQLConnect;
import az.Allahshukur.entity.StudentEntity;
import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentRepository {

    public void insert(StudentEntity student) throws  Exception{
        Connection connection = MySQLConnect.connect();
        PreparedStatement preparableStatement = connection.prepareStatement("insert into student(name,surname,age,scholarship) values(?,?,?,?)");
        preparableStatement.setString(1,student.getName());
        preparableStatement.setString(2,student.getSurname());
        preparableStatement.setInt(3,student.getAge());
        preparableStatement.setBigDecimal(4,student.getScholarship());
    }


}
