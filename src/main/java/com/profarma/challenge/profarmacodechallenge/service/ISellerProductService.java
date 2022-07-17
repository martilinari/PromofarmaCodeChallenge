package com.profarma.challenge.profarmacodechallenge.service;

import com.profarma.challenge.profarmacodechallenge.dto.SellerProductDto;

import java.util.List;

public interface ISellerProductService {

    void addProductsToSeller(Long sellerId, List<SellerProductDto> sellerProductDto);

    void removeProductToSeller(Long sellerId, Long productId);

}
