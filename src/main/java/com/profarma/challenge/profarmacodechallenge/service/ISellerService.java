package com.profarma.challenge.profarmacodechallenge.service;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;

import java.util.List;

public interface ISellerService {

    void save(SellerDto sellerDto);

    SellerDto findSellerByName(SellerDto sellerDto);

    List<SellerDto> getAllSellers();

    SellerDto findById(Long id);

    void deleteSeller(Long id);
//
//
//    List<SellerDto> findAll();
}
