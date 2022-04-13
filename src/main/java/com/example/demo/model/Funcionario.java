package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario {
   @Id
    private Integer id;
    private String nome;
}

