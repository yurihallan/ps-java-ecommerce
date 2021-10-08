package com.superogame.supero.Entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public long id;

   public String name;

   public BigDecimal price;

   public short score;

   public String image;

}