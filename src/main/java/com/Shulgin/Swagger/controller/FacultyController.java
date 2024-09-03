package com.Shulgin.Swagger.controller;

import com.Shulgin.Swagger.model.Faculty;
import com.Shulgin.Swagger.model.Student;
import com.Shulgin.Swagger.service.FacultyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    private final FacultyService service;

    public FacultyController(FacultyService service) {
        this.service = service;
    }
    @GetMapping
    public Faculty get(@RequestParam long id) {
        return service.get(id);
    }

    @PostMapping
    public Faculty add(@RequestBody Faculty faculty) {
        return service.add(faculty);
    }

    @DeleteMapping
    public boolean delete(@RequestParam long id) {
        return service.delete(id);
    }

    @PutMapping
    public Faculty update(@RequestBody Faculty faculty) {
        return service.update(faculty);
    }

    @GetMapping("/byColorAndName")
    public Collection<Faculty> getByColor(@RequestParam(required = false) String color,
                                          @RequestParam(required = false) String name) {
        if (StringUtils.isEmpty(color) && !StringUtils.isEmpty(name)) {
            return service.getByColorAndName(color, name);
        }
        return service.getAll();
    }

}
