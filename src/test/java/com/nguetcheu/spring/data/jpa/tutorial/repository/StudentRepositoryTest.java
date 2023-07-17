package com.nguetcheu.spring.data.jpa.tutorial.repository;

import com.nguetcheu.spring.data.jpa.tutorial.entity.Guardian;
import com.nguetcheu.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    /*public StudentRepositoryTest(StudentRepository theStudentRepository) {
        this.studentRepository = theStudentRepository;
    }*/

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("dnguetcheu@gmail.com")
                .firstName("nguetcheu")
                .lastName("dominique")
                //.guardianName("Noumangue")
                //.guardianEmail("noucharles@gmail.com")
                //.guardianMobile("693693748")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("noucharles@gmail.com")
                .name("Noumangue")
                .mobile("693693748")
                .build();

        Student student = Student.builder()
                .firstName("nguetcheu")
                .emailId("nguetcheu@gmail.com")
                .lastName("dominique")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void ListStudent(){
        List<Student> studentList =
        studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("nguetcheu");

        System.out.println("studens = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("ng");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("Noumangue");

        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "nguetcheu@gmail.com"
                );
        System.out.println("student = " +student);
    }

    @Test
    public void getStudentByEmailAddressAndLastName() {
        Student student =
                studentRepository.getStudentByEmailAddressAndLastName(
                        "nguetcheu@gmail.com", "dominique"
                );
        System.out.println("student = " +student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "nguetcheu@gmail.com"
                );
        System.out.println("student = " +firstName);
    }

    @Test
    public void getStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                       "nguetcheu@gmail.com"
                );
        System.out.println("student = " +student);
    }

    @Test
    public void getStudentByEmailAddressNativeNameParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeNameParam(
                        "nguetcheu@gmail.com"
                );
        System.out.println("student = " +student);
    }

    @Test
    public void updateStudentNameByEmailId() {
        studentRepository.updateStudentNameByEmailId(
                "nguetcheu 237",
                "nguetcheu@gmail.com");
    }

}