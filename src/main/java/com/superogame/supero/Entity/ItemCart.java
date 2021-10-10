package com.superogame.supero.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemCart {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public long id;
   @NotNull
   public Long id_client;
   @NotNull
   public Long id_product;

   public Integer qtdProduct;



   

}