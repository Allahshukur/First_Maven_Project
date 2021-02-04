package az.Allahshukur;

import az.Allahshukur.entity.StudentEntity;
import az.Allahshukur.repository.StudentRepository;

/**
 * Hello world!
 */
public class App {
    private static StudentRepository studentRepository = new StudentRepository();
    private static StudentEntity studentEntity = new StudentEntity();

    public static void main(String[] args) throws Exception {

//        List<StudentEntity> list = studentRepository.getAll();
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

        System.out.println(studentRepository.findList("ALLAHSHUKUR",null,null,null));

//        List<StudentEntity> list2 = studentRepository.getAll();
//
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list2.get(i));
//        }
    }
}
