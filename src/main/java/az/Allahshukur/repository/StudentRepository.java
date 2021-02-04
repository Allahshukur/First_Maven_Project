package az.Allahshukur.repository;

import az.Allahshukur.Connect.MySQLConnect;
import az.Allahshukur.entity.StudentEntity;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    public void insert(StudentEntity student) {
        try(Connection connection = MySQLConnect.connect();) {
            PreparedStatement preparableStatement = connection.prepareStatement(
                    "insert into student(stu_name,stu_surname,stu_age,stu_scholarship) " +
                            "values(?,?,?,?)");
            preparableStatement.setString(1, student.getName());
            preparableStatement.setString(2, student.getSurname());
            preparableStatement.setInt(3, student.getAge());
            preparableStatement.setBigDecimal(4, student.getScholarship());

            preparableStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(StudentEntity student) {
        try(Connection connection = MySQLConnect.connect();) {
            PreparedStatement preparableStatement = connection.prepareStatement(
                    "update student set stu_name=?,stu_surname=?,stu_age=?,stu_scholarship=? where stu_id=?");
            preparableStatement.setString(1, student.getName());
            preparableStatement.setString(2, student.getSurname());
            preparableStatement.setInt(3, student.getAge());
            preparableStatement.setBigDecimal(4, student.getScholarship());
            preparableStatement.setInt(5,student.getId());

            preparableStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try(Connection connection = MySQLConnect.connect();) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from student where stu_id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<StudentEntity> getAll(){

        List<StudentEntity> list = new ArrayList<>();
        try(Connection connection = MySQLConnect.connect()) {
            ResultSet rs = connection.prepareStatement("select * from student").executeQuery();
            while (rs.next()) list.add(fromResultSet(rs));
        System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public StudentEntity findById(int id){

        try(Connection connection = MySQLConnect.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("select from student where id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) return fromResultSet(rs);
            System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<StudentEntity> findList(String name, String surname, Integer age, BigDecimal scholarship){

        String query = "select * from student where 1=1 ";

        int index=0;
        if (name!=null && name.trim().length()>0){
            query+=" and stu_name like ?";
            index++;
        }
        if (surname!=null && surname.trim().length()>0){
            query+=" and stu_surname like ?";
            index++;
        }
        if (age!=null && age>0){
            query+=" and stu_age like ?";
            index++;
        }
        if (scholarship!=null && scholarship.compareTo(BigDecimal.ZERO)>0){
            query+=" and stu_scholarship like ?";
            index++;
        }

        List<StudentEntity> list = new ArrayList<>();
        try(Connection connection = MySQLConnect.connect()) {
            PreparedStatement preparedStatement =connection.prepareStatement(query);
            if (scholarship!=null && scholarship.compareTo(BigDecimal.ZERO)>0){
                preparedStatement.setBigDecimal(index--,scholarship);
            }
            if (age!=null && age>0) {
                preparedStatement.setInt(index--,age);
            }
            if (surname!=null && surname.trim().length()>0){
                preparedStatement.setString(index--,"%"+surname+"%");
            }
            if (name!=null && name.trim().length()>0){
                preparedStatement.setString(index--,"%"+name+"%");
            }
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) list.add(fromResultSet(rs));
            System.out.println("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }


//    private StudentEntity fromResultSet(ResultSet rs) throws Exception{
//        StudentEntity studentEntity= new StudentEntity();
//        studentEntity.setId(rs.getInt("id"));
//        studentEntity.setName(rs.getString("name"));
//        studentEntity.setSurname(rs.getString("surname"));
//        studentEntity.setAge(rs.getInt("age"));
//        studentEntity.setScholarship(rs.getBigDecimal("scholarship"));
//
//        return studentEntity;
//
//    }

    private StudentEntity fromResultSet(ResultSet rs) throws Exception{
        return new StudentEntity()
                .setId(rs.getInt("stu_id"))
                .setName(rs.getString("stu_name"))
                .setSurname(rs.getString("stu_surname"))
                .setAge(rs.getInt("stu_age"))
                .setScholarship(rs.getBigDecimal("stu_scholarship"));
    }












}
