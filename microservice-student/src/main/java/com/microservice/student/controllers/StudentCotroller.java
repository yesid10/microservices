package com.microservice.student.controllers;

import com.microservice.student.model.Student;
import com.microservice.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/students")
public class StudentCotroller {

    @Autowired
    private StudentService studentService;

    //Get
    @GetMapping("/list")
    public List<Student> listStudents(){
        return studentService.getAllStudent();
    }

    //Get One Student
    @GetMapping("/list/{id}")
    public Student listOneStudent(@PathVariable Long id){
        return studentService.getOneStudent(id);
    }

    //POST
    @PostMapping("/save")
    public Student createStudent(@PathVariable Student student){
        return studentService.saveStudent(student);
    }

    //PUT
    @PutMapping("/edit/{id}")
    public Student editStudent(@PathVariable Student student, @PathVariable Long id){
        student.setId(id);
        return studentService.updateStudent(student);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
