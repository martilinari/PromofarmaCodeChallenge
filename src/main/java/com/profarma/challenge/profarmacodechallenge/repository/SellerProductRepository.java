package com.profarma.challenge.profarmacodechallenge.repository;

import com.profarma.challenge.profarmacodechallenge.entity.SellerProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SellerProductRepository extends JpaRepository<SellerProductEntity, Long> {

    @Query("SELECT u FROM SellerProductEntity u WHERE u.primaryKey.product.id = :productId and u.primaryKey.seller.id = :sellerId")
    SellerProductEntity findBySellerAndProduct(Long sellerId, Long productId);

}