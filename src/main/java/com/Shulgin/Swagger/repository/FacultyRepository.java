package com.Shulgin.Swagger.repository;

import com.Shulgin.Swagger.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Collection<Faculty> findAllByColorOrNameIgnoreCase(String color, String name);
}
