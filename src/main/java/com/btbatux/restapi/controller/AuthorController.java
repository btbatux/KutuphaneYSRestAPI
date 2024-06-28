package com.btbatux.restapi.controller;

import com.btbatux.restapi.customExeption.NotFoundException;
import com.btbatux.restapi.dto.AuthorCreateDTO;
import com.btbatux.restapi.dto.AuthorDto;
import com.btbatux.restapi.entities.Author;
import com.btbatux.restapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.module.ResolutionException;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDto> gettAllAuthor() {
        return this.authorService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto getAuthorById(@PathVariable Long id) {
        return this.authorService.findById(id);
    }

    @PostMapping //Yazar ekleme
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto save(@RequestBody AuthorCreateDTO authorCreateDTO) {
        return this.authorService.save(authorCreateDTO);
    }

    @PutMapping("/{id}") //Yazar Güncelleme
    public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Long id, @RequestBody AuthorCreateDTO authorCreateDTO) {
        return ResponseEntity.ok(authorService.update(id, authorCreateDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);

    }
}
