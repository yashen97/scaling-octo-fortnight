package com.yashen.school.services.Impl;

import com.yashen.school.entity.Student;
import com.yashen.school.repositories.StudentRepo;
import com.yashen.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student addOrUpdate(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getStudentList() {
        return studentRepo.findAll();
    }



    @Override
    public List<Student> getNotDeletedStudents() {
        return studentRepo.findByIsDeletedOrderByIdDesc(0);
    }

    @Override
    public Student getByName(String name) {
        return studentRepo.findByName(name);
    }

    @Override
    public List<Student> getGradList() {
        return studentRepo.findByIsGraduatedOrderByIdDesc(1);
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepo.findById(id);
    }

    @Override
    public Student fetchById(Long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public List<Student> saveList(List<Student> studentList) {
        return studentRepo.saveAll(studentList);
    }

    @Override
    public Integer deleteById(Long id) {
        Student student=studentRepo.findById(id).get();
        student.setIsDeleted(1);
        studentRepo.save(student);
        return 1;
    }
}
