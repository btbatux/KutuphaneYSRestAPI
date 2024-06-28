package com.btbatux.restapi.service;

import com.btbatux.restapi.customExeption.NotFoundException;
import com.btbatux.restapi.dto.AuthorCreateDTO;
import com.btbatux.restapi.dto.AuthorDto;
import com.btbatux.restapi.entities.Author;
import com.btbatux.restapi.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
    }


    public List<AuthorDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().
                map(author -> modelMapper.map(author, AuthorDto.class)).
                collect(Collectors.toList());
    }

    public AuthorDto findById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Yazar Bulunamadı"));
        return modelMapper.map(author, AuthorDto.class);
    }

    public AuthorDto save(AuthorCreateDTO authorCreateDTO) {
        Author author = modelMapper.map(authorCreateDTO, Author.class);
        author = authorRepository.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }

    public AuthorDto update(Long id, AuthorCreateDTO authorCreateDTO) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Yazar Bulunamadı.."));
        author.setName(authorCreateDTO.getName());
        author.setBirthDate(authorCreateDTO.getBirthDate());
        author.setCountry(authorCreateDTO.getCountry());

        author = authorRepository.save(author);
        return modelMapper.map(author, AuthorDto.class);
    }

    public void deleteById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));

        authorRepository.delete(author);
    }

}
