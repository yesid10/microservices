package com.microservice.curso.services;

import com.microservice.curso.model.Course;
import com.microservice.curso.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceCourse {

    @Autowired
    private CourseRepository courseRepository;

    //Fuction for get all course
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    //Fuction for get One course
    public Course getOneCourse(Long id){
        return courseRepository.findById(id).orElse(null);
    }

    //Fuction for save a course
    public Course saveCourse(Course course){
        return  courseRepository.save(course);
    }

    //Fuction for update a course
    public Course updateCourse(Course course){
        return  courseRepository.save(course);
    }

    //Fuction for delete a course
    public void deleteCourse(Long id){
        courseRepository.deleteById(id);
    }
}
