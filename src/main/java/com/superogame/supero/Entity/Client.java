package com.superogame.supero.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Client {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public long id;

   public String name;

   public String cpf;

}