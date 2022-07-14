package com.profarma.challenge.profarmacodechallenge.service.implementation;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import com.profarma.challenge.profarmacodechallenge.repository.ProductRepository;
import com.profarma.challenge.profarmacodechallenge.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("productService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @Transactional
    public void save(ProductDto productDto) {
        productRepository.save(convertDtoToEntity(productDto));
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto findProductByName(ProductDto productDto) {
        return convertEntityToDto(productRepository.findByProductName(productDto.getProductName()));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
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


    private ProductDto convertEntityToDto(ProductEntity productEntity) {
        ProductDto productDto = null;
        if (productEntity != null) {
            new ProductDto();
            productDto = modelMapper.map(productEntity, ProductDto.class);
        }
        return productDto;
    }

    private ProductEntity convertDtoToEntity(ProductDto productDto) {
        ProductEntity productEntity = null;
        if (productDto != null) {
            new ProductEntity();
            productEntity = modelMapper.map(productDto, ProductEntity.class);
        }
        return productEntity;
    }
}
