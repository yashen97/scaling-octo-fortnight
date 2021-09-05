package com.yashen.school.repositories;

import com.yashen.school.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

    List<Student> findByIsGraduatedOrderByIdDesc(Integer isGraduated);
    List<Student> findByIsDeletedOrderByIdDesc(Integer isDeleted);
    Student findByName(String name);

}
