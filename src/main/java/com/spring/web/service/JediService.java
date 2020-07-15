package com.spring.web.service;

import com.spring.web.exception.JediNotFoundException;
import com.spring.web.model.Jedi;
import com.spring.web.repository.JediRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class JediService {

    @Autowired
    private JediRepository repository;

    public Iterable<Jedi> findAll() {
        return repository.findAll();
    }

    public Jedi findById(Long id) {
        final Optional<Jedi> jedi = repository.findById(id);
        if (jedi.isPresent()) {
            return jedi.get();
        } else {
            throw new JediNotFoundException();
        }
    }

    public Jedi save(Jedi jedi) {
        return repository.save(jedi);
    }

    public void delete(final Long id) {
        final Jedi jedi = findById(id);
        repository.delete(jedi);
    }

    public Jedi update(Long id, Jedi jediDto) {
        final Optional<Jedi> jediEntity = repository.findById(id);
        final Jedi jedi;

        if (jediEntity.isPresent()) {
            jedi = jediEntity.get();
        } else  {
            throw new JediNotFoundException();
        }
        jedi.setNome(jediDto.getNome());
        jedi.setLastName(jediDto.getLastName());

        return repository.save(jedi);

    }
}
