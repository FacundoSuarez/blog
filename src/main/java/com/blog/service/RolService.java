/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.service;

import com.blog.domain.Rol;
import com.blog.repository.RolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Facundo
 */
@Service
public class RolService {
    
    private final RolRepository rolRepository;

    public RolService(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }
    
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }
   
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    public Optional<Rol> findOne(Long id) {
        return rolRepository.findById(id);
    }

    public void delete(Long id) {
        rolRepository.deleteById(id);
    }
    
}
