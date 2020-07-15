package com.spring.web.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
public class Jedi {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 20, message = "Name must have between 3 and 20 letters")
    private String nome;

    @Size(max = 20, message = "Last Name must not have more than 20 letters")
    private String lastName;

    public Jedi (String name, String lastName) {
        this.nome = name;
        this.lastName = lastName;
    }

    public Jedi () {
        super();
    }

}