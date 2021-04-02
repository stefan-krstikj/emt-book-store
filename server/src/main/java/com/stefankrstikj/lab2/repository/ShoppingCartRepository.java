package com.stefankrstikj.lab2.repository;

import com.stefankrstikj.lab2.model.ShoppingCart;
import com.stefankrstikj.lab2.model.User;
import com.stefankrstikj.lab2.model.enumerations.ShoppingCartStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
}
