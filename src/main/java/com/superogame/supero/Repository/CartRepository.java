package com.superogame.supero.Repository;

import java.util.List;

import com.superogame.supero.Entity.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart,Long>{

    @Query(value = "SELECT c.* FROM CART c WHERE c.id_client = ?1",nativeQuery = true)
    public List<Cart> getCheckout(Long id_client);
}
