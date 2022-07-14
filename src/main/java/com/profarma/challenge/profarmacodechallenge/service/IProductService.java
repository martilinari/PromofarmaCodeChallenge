package com.profarma.challenge.profarmacodechallenge.service;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;

import java.util.List;

public interface IProductService {
    List<ProductDto> getAllProducts();

    void save(ProductDto productDto);

    ProductDto findProductByName(ProductDto productDto);

    ProductEntity findById(Long id);

    void deleteProduct(Long id);

}
