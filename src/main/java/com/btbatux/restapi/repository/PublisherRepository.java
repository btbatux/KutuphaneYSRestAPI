package com.btbatux.restapi.repository;

import com.btbatux.restapi.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
