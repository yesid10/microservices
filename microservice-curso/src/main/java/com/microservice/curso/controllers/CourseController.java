package com.microservice.curso.controllers;

import com.microservice.curso.http.response.StudentByCourseResponse;
import com.microservice.curso.model.Course;
import com.microservice.curso.services.ServiceCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1/courses")
public class CourseController {

    @Autowired
    private ServiceCourse serviceCourse;

    //GET
    @GetMapping("/list")
    public List<Course> listCourses(){
        return serviceCourse.getAllCourses();
    }

    //GET ONE PRODUCT
    @GetMapping("/list/{id}")
    public Course listOneCourse(@PathVariable Long id){
        return serviceCourse.getOneCourse(id);
    }

    //POST
    @PostMapping("/save")
    public Course createCourse(@RequestBody Course course){
        return serviceCourse.saveCourse(course);
    }

    //PUT
    @PutMapping("/edit/{id}")
    public Course editCourse(@RequestBody Course course, @PathVariable Long id){
        course.setId(id);
        return serviceCourse.updateCourse(course);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteCourse(@PathVariable Long id){
        serviceCourse.deleteCourse(id);
    }

    @GetMapping("/student-course/{idCourse}")
    public StudentByCourseResponse findStudentByCourse(@PathVariable Long idCourse){
        return serviceCourse.findStudentsByIdCourse(idCourse);
    }
}
