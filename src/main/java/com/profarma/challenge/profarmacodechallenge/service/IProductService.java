package com.profarma.challenge.profarmacodechallenge.service;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getAllProducts();

    void save(ProductDto productDto);

    ProductDto findProductByName(ProductDto productDto);

    ProductDto findById(Long id);

    void deleteProduct(Long id);

}
