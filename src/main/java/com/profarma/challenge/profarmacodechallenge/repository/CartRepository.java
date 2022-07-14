package com.profarma.challenge.profarmacodechallenge.repository;

import com.profarma.challenge.profarmacodechallenge.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
