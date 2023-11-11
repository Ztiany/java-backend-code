package me.ztiany.springboot.web;

import me.ztiany.springboot.web.bean.Student;
import me.ztiany.springboot.web.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {WebDevApplication.class})
public class JAPTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testJPA() {
        studentRepository.save(new Student(1, "Alien", "Alien@god.com"));
    }

}
