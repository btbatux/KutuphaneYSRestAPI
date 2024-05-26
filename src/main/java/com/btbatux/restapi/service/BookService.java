package com.btbatux.restapi.service;

import com.btbatux.restapi.customExeption.NotFoundException;
import com.btbatux.restapi.entities.Book;
import com.btbatux.restapi.repository.BookRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired //Spring'e bağımlılığın bu sınıfa otomatik olarak enjekte edilmesi gerektiğini söyler.
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }




    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Kitap Bulunamadı"));


    }

    public void deleteById(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new RuntimeException("Bu kitap mevcut değil.");
        }

        bookRepository.deleteById(id);
    }
}