package com.btbatux.restapi.repository;

import com.btbatux.restapi.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookBorrowingRepository extends JpaRepository<BookBorrowing,Long> {
}
