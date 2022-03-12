package me.ztiany.springboot.web.repository;

import me.ztiany.springboot.web.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}