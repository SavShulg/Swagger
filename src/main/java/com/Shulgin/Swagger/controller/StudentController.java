package com.Shulgin.Swagger.controller;

import com.Shulgin.Swagger.model.Student;
import com.Shulgin.Swagger.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public Student get(@RequestParam long id) {
        return service.get(id);
    }

    @PostMapping
    public Student add(@RequestBody Student student) {
        return service.add(student);
    }

    @DeleteMapping
    public boolean delete(@RequestParam long id) {
        return service.delete(id);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }

    @GetMapping("/byAge")
    public Collection<Student> getByAgeBetween(@RequestParam(required = false) Integer min,
                                               @RequestParam(required = false) Integer max) {
        if (min != null && max != null) {
            return service.getByAgeBetween(min, max);
        }
        return service.getAll();
    }
}
