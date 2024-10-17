package com.microservice.curso.services;

import com.microservice.curso.client.StudentClient;
import com.microservice.curso.dto.StudentDTO;
import com.microservice.curso.http.response.StudentByCourseResponse;
import com.microservice.curso.model.Course;
import com.microservice.curso.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceCourse {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentClient studentClient;

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

    public StudentByCourseResponse findStudentsByIdCourse(Long idCourse){

        //Consulatar el curso
        Course course = courseRepository.findById(idCourse).orElse(new Course());

        //Obtener estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStudentByCourse(idCourse);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
