package com.profarma.challenge.profarmacodechallenge.repository;

import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
