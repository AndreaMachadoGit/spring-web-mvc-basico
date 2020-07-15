package com.spring.web.rest;


import com.spring.web.model.Jedi;
import com.spring.web.repository.JediRepository;
import com.spring.web.service.JediService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class JediResource {

    @Autowired
    private JediService service;

    @GetMapping("/api/jedi")
    public Iterable<Jedi> getAllJedi() {
        return service.findAll();
    }

    @GetMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> getJedi(@PathVariable("id") Long id) {
        final Jedi jedi = service.findById(id);

            return ResponseEntity.ok(jedi);

    }

    @PostMapping("/api/jedi")
    @ResponseStatus(HttpStatus.CREATED)
    public Jedi createJedi(@Valid @RequestBody Jedi jedi){
        return service.save(jedi);
    }


    @PutMapping("/api/jedi")
    public Jedi updateJedi(@Valid @RequestBody Jedi jedi){
        // alteracao do objeto passando o id na uri
        return service.save(jedi);
    }

    @PutMapping("/api/jedi/{id}")
    public ResponseEntity<Jedi> updateJedi(@PathVariable("id") Long id, @Valid @RequestBody Jedi jediDto){

        //alteracao do objeto passando o id no json (sem passar na Uri)
        final Jedi jedi = service.update(id, jediDto);
        return ResponseEntity.ok(jedi);
    }

    @DeleteMapping("/api/jedi/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

}
