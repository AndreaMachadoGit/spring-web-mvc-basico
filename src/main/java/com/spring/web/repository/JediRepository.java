package com.spring.web.repository;


import java.util.List;

import com.spring.web.model.Jedi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JediRepository extends CrudRepository<Jedi, Long> {

    List<Jedi> findByNomeContainingIgnoreCase(final String nome);
}