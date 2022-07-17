package com.profarma.challenge.profarmacodechallenge.service.implementation;

import com.profarma.challenge.profarmacodechallenge.dto.SellerProductDto;
import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import com.profarma.challenge.profarmacodechallenge.entity.SellerProductEntity;
import com.profarma.challenge.profarmacodechallenge.repository.ProductRepository;
import com.profarma.challenge.profarmacodechallenge.repository.SellerProductRepository;
import com.profarma.challenge.profarmacodechallenge.repository.SellerRepository;
import com.profarma.challenge.profarmacodechallenge.service.ISellerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;

@Service("sellerProductService")
public class SellerProductImpl implements ISellerProductService {

    @Autowired
    private SellerProductRepository sellerProductRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Transactional(rollbackFor = ResponseStatusException.class)
    public void addProductsToSeller(Long sellerId, List<SellerProductDto> sellerProductDto) {
        SellerEntity sellerEntity = sellerRepository.findById(sellerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller Not Found: " + sellerId));
        sellerProductDto.stream().forEach((p) -> {
            ProductEntity productEntity = productRepository.findById(p.getProductId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found: " + p.getProductId()));
            SellerProductEntity sellerProductEntity = new SellerProductEntity();
            sellerProductEntity.setSeller(sellerEntity);
            sellerProductEntity.setProduct(productEntity);
            if (p.getPrice().compareTo(BigDecimal.ZERO) > 0) {
                sellerProductEntity.setPrice(p.getPrice());
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Price must be bigger than 0");
            }
            sellerProductRepository.save(sellerProductEntity);
        });
    }

    @Override
    @Transactional(rollbackFor = ResponseStatusException.class)
    public void removeProductToSeller(Long sellerId, Long productId) {
        sellerRepository.findById(sellerId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Seller Not Found: " + sellerId));
        productRepository.findById(productId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product Not Found: " + productId));
        SellerProductEntity sellerProductEntity = sellerProductRepository.findBySellerAndProduct(sellerId, productId);
        if (sellerProductEntity != null) {
            sellerProductRepository.delete(sellerProductEntity);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product " + productId + " and seller " + sellerId + " are not linked");
        }
    }

}
