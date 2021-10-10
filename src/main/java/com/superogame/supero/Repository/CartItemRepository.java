package com.superogame.supero.Repository;

import com.superogame.supero.Entity.ItemCart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<ItemCart,Long>{
    
}
