package com.nguetcheu.spring.data.jpa.tutorial.repository;

import com.nguetcheu.spring.data.jpa.tutorial.entity.Course;
import com.nguetcheu.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;


    @Test
    public void saveTeacher(){

        Course courseDBA =
                Course.builder()
                        .title("DBA")
                        .credit(5)
                        .build();

        Course courseJava =
                Course.builder()
                        .title("Java")
                        .credit(6)
                        .build();

        List<Course> courseList = new ArrayList<>();
        courseList.add(courseDBA);
        courseList.add(courseJava);

        Teacher teacher =
                Teacher.builder()
                        .firstName("Qutub")
                        .lastName("Khan")
                        .courses(courseList)
                        .build();

        teacherRepository.save(teacher);
    }
}