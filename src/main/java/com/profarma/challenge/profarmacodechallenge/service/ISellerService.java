package com.profarma.challenge.profarmacodechallenge.service;

import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;

import java.util.List;

public interface ISellerService {

    void save(SellerEntity seller);

    SellerEntity findById(Long id);

    void deleteSeller(Long id);

    SellerEntity findSeller(SellerEntity seller);

    List<SellerDto> findAll();
}
