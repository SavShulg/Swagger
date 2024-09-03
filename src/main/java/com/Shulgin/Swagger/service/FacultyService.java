package com.Shulgin.Swagger.service;

import com.Shulgin.Swagger.exceptions.RecordNotFoundException;
import com.Shulgin.Swagger.model.Faculty;
import com.Shulgin.Swagger.model.Student;
import com.Shulgin.Swagger.repository.FacultyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {

    private final FacultyRepository repository;

    public FacultyService(FacultyRepository repository) {
        this.repository = repository;
    }

    public Faculty add(Faculty faculty) {
        return repository.save(faculty);
    }

    public Faculty get(long id) {
        return repository.findById(id).orElseThrow(RecordNotFoundException::new);
    }

    public boolean delete(long id) {
        return repository.findById(id)
                .map(entity -> {
                    repository.delete(entity);
                    return true;
                })
                .orElse(false);
    }

    public Faculty update(Faculty faculty) {
        return repository.findById(faculty.getId())
                .map(entity -> repository.save(faculty))
                .orElse(null);
    }

    public Collection<Faculty> getByColorAndName(String color, String name) {
        return repository.findAllByColorOrNameIgnoreCase(color, name);
    }

    public Collection<Faculty> getAll() {
        return repository.findAll();
    }
}
