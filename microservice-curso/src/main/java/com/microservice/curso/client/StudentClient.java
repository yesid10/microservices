package com.microservice.curso.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8090/api/v1/students")
public class StudentClient {
    @GetMapping("/search-course/{idCourse}")
    List<?> findAllStudentByCourse(@PathVariable Long id);
}
