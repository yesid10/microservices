package com.microservice.student.service;

import com.microservice.student.model.Student;
import com.microservice.student.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //return all students
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    //return one student
    public Student getOneStudent(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    //save one student
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    //uptade a student
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }

    //delete a student
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
