package com.profarma.challenge.profarmacodechallenge.repository;

import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<SellerEntity, Long> {

    SellerEntity findByEmail(String email);

    Optional<SellerEntity> findById(Long id);

}
