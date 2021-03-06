/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.domain.Author;
import com.blog.domain.Entry;
import com.blog.repository.EntryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Facundo
 */
@Service
public class EntryService{
    
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }
    
    
    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }
   
    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Optional<Entry> findOne(Long id) {
        return entryRepository.findById(id);
    }

    public void delete(Long id) {
        entryRepository.deleteById(id);
    }
    
}
