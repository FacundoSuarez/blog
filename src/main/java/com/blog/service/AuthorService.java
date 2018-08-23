/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.domain.Author;
import com.blog.repository.AuthorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Facundo
 */
@Service
public class AuthorService {
    
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    
    public Author save(Author author) {
        return authorRepository.save(author);
    }
   
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Optional<Author> findOne(Long id) {
        return authorRepository.findById(id);
    }

    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
