package com.btbatux.restapi.repository;

import com.btbatux.restapi.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
