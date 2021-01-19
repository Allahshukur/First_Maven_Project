package az.Allahshukur;

import az.Allahshukur.Connect.MySQLConnect;
import az.Allahshukur.entity.StudentEntity;
import az.Allahshukur.repository.StudentRepository;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    private static StudentRepository studentRepository = new StudentRepository();
    private static StudentEntity studentEntity = new StudentEntity();

    public static void main(String[] args) throws Exception {

        studentRepository.insert(
                new StudentEntity()
                        .setName(new Scanner(System.in).nextLine())
                        .setSurname(new Scanner(System.in).nextLine())
                        .setAge(new Scanner(System.in).nextInt())
                        .setScholarship(new Scanner(System.in).nextBigDecimal())
        );

//        studentEntity.setName(new Scanner(System.in).nextLine());
//        studentEntity.setSurname(new Scanner(System.in).nextLine());
//        studentEntity.setAge(new Scanner(System.in).nextInt());
//        studentEntity.setScholarship(new Scanner(System.in).nextBigDecimal());
//        studentRepository.insert(studentEntity);


        List<StudentEntity> list = studentRepository.getAll();

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
