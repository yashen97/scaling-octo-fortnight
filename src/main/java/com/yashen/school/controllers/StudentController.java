package com.yashen.school.controllers;

import com.yashen.school.entity.Student;
import com.yashen.school.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping()
    public Student save(@RequestBody Student student){
        return studentService.addOrUpdate(student);
    }

    @PostMapping("postAll")
    public List<Student> saveAll(@RequestBody List<Student> studentList){
        return studentService.saveList(studentList);
    }

    @PutMapping("update")
    public Student update(@RequestBody Student student){
        return studentService.addOrUpdate(student);
    }

    @GetMapping("getall")
    public @ResponseBody List<Student> gellAllStudents(){
        return studentService.getStudentList();
    }


    @GetMapping("graduated")
    public @ResponseBody List<Student> getGraduatedStudents(){return studentService.getGradList();}

    @GetMapping("/notDeleted")
    public @ResponseBody List<Student> getNotDeletedStudents(){
        return studentService.getNotDeletedStudents();
    }

    @GetMapping("name/{name}")
    public Student getStudentByName(@PathVariable String name){
        return studentService.getByName(name);
    }

    @GetMapping("{id}")
    public Optional<Student> findStudent(@PathVariable Long id){
        return studentService.findOne(id);
    }

    @GetMapping("get/{id}")
    public Student fetchStudentById(@PathVariable("id") Long id){
        return studentService.fetchById(id);
    }

    @DeleteMapping("delete/{id}")
    public Integer delete(@PathVariable Long id){
        return studentService.deleteById(id);
    }
}
