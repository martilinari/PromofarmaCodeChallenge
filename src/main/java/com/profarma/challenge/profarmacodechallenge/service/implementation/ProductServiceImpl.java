package com.profarma.challenge.profarmacodechallenge.service.implementation;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import com.profarma.challenge.profarmacodechallenge.mapper.Mapper;
import com.profarma.challenge.profarmacodechallenge.repository.ProductRepository;
import com.profarma.challenge.profarmacodechallenge.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    @Qualifier("Mapper")
    private Mapper mapper;

    @Override
    @Transactional
    public void save(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductEntity findProduct(ProductEntity product) {
        return productRepository.findByProductName(product.getProductName());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return mapper.convertListProduct(productRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductEntity findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
