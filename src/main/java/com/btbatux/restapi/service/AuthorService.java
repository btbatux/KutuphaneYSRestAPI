package com.btbatux.restapi.service;
import com.btbatux.restapi.customExeption.NotFoundException;
import com.btbatux.restapi.entities.Author;
import com.btbatux.restapi.repository.AuthorRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;


    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Yazar Bulunamadı"));
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

    public Author update(Long id, Author author) {
        if (!authorRepository.existsById(id)) {
            throw new NotFoundException("Author with id " + id + " not found.");
        }
        return authorRepository.save(author);
    }

    public void deleteById(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new NotFoundException("Bu yazar mevcut değil.");
        }

        authorRepository.deleteById(id);
    }

}
