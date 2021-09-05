package com.yashen.school.services;

import com.yashen.school.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student addOrUpdate(Student student);

    List<Student> getStudentList();

    List<Student> getNotDeletedStudents();

    Student getByName(String name);

    List<Student> getGradList();

    Optional<Student> findOne(Long id);

    Student fetchById(Long id);

    List<Student> saveList(List<Student> studentList);

    Integer deleteById(Long id);
}
