/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.domain.Author;
import com.blog.domain.Subject;
import com.blog.repository.SubjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Facundo
 */
@Service
public class SubjectService {
    
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }
   
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Optional<Subject> findOne(Long id) {
        return subjectRepository.findById(id);
    }

    public void delete(Long id) {
        subjectRepository.deleteById(id);
    }
    
}
