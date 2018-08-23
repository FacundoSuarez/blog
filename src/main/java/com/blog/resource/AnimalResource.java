/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blog.resource;

import com.blog.domain.Author;
import com.blog.service.AuthorService;
import com.blog.service.util.HeaderUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Facundo
 */
@CrossOrigin
@Controller
public class AnimalResource {
    
    private static final Logger log = LoggerFactory.getLogger(AnimalResource.class);
    
    private static final String ENTITY_NAME = "ANIMAL";

    private final AuthorService authorService;

    public AnimalResource(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * POST  /animal : Crea animal.
     * @param animal
     */
    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) throws URISyntaxException {
        log.info("REST peticion para crear "+ENTITY_NAME+": {}");
        if (author.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede crear un objeto con ese ID");
        }
        Author result = authorService.save(author);
        return ResponseEntity.created(new URI("/api/animals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /animal : upgradea un animal existente 
     *
     * @param animal the animal to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated animal,
     * or with status 400 (Bad Request) if the animal is not valid,
     * or with status 500 (Internal Server Error) if the animal couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/author")
    public ResponseEntity<Author> updateAuthor(@RequestBody Author animal) throws URISyntaxException {
        log.debug("REST peticion para update "+ENTITY_NAME+" : {}", animal);
        if (animal.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"ID null");
        }
        Author result = authorService.save(animal);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, animal.getId().toString()))
            .body(result);
    }

    /**
     * GET  /animals : todos los animales
     * @return the ResponseEntity with status 200 (OK) and the list of animals in body
     */
    
    @GetMapping("/authors")
    public @ResponseBody List<Author> getAllAuthors() {
        log.debug("REST peticion de todos los "+ENTITY_NAME);
        return authorService.findAll();
    }

    /**
     * GET  /animals/:id : get the "id" animal.
     *
     * @param id the id of the animal to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the animal, or with status 404 (Not Found)
     */
    @GetMapping("/author/{id}")
    public @ResponseBody Optional<Author> getAuthor(@PathVariable Long id) {
        log.debug("REST peticion de "+ENTITY_NAME+" : {}", id);
        Optional<Author> author = authorService.findOne(id);
        if(author.orElse(null) == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No existe un animal con ese ID");
        }
        return author;
    }

    /**
     * DELETE  /animals/:id : delete the "id" animal.
     *
     * @param id the id of the animal to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/author/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        log.debug("REST peticion para eliminar "+ENTITY_NAME+" : {}", id);
        authorService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
