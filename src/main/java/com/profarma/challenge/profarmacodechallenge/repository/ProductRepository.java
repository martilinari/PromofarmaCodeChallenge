package com.profarma.challenge.profarmacodechallenge.repository;

import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    ProductEntity findByProductName(String productName);

    @Modifying
    @Query("delete from ProductEntity where productName = LOWER(:productName)  ")
    void deleteByProductName(String productName);

}
