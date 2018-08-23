/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.domain.Tag;
import com.blog.repository.TagRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Facundo
 */
@Service
public class TagService {
    
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    
    public Tag save(Tag tag) {
        return tagRepository.save(tag);
    }
   
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public Optional<Tag> findOne(Long id) {
        return tagRepository.findById(id);
    }

    public void delete(Long id) {
        tagRepository.deleteById(id);
    }
    
}
