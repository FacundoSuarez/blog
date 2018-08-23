/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.domain.Lenguage;
import com.blog.repository.LenguageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Facundo
 */
@Service
public class LenguageService {
    
    private final LenguageRepository lenguageRepository;

    public LenguageService(LenguageRepository lenguageRepository) {
        this.lenguageRepository = lenguageRepository;
    }
    
    public Lenguage save(Lenguage lenguaje) {
        return lenguageRepository.save(lenguaje);
    }
   
    public List<Lenguage> findAll() {
        return lenguageRepository.findAll();
    }

    public Optional<Lenguage> findOne(Long id) {
        return lenguageRepository.findById(id);
    }

    public void delete(Long id) {
        lenguageRepository.deleteById(id);
    }
    
}
