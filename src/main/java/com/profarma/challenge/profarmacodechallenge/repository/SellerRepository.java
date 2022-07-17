package com.profarma.challenge.profarmacodechallenge.repository;

import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

    SellerEntity findBySellerName(String sellerName);


}
