package com.superogame.supero.Repository;

import java.util.List;

import com.superogame.supero.Entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{
    
    // Ordernando por nome
    List<Product> findByOrderByNameAsc();
    List<Product> findByOrderByNameDesc();
    
    //Ordernando por preço
    List<Product> findByOrderByPriceAsc();
    List<Product> findByOrderByPriceDesc();

    //Ordernando por Popularidade
    List<Product> findByOrderByScoreAsc();
    List<Product> findByOrderByScoreDesc();
  
}
