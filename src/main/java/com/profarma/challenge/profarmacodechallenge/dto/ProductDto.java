package com.profarma.challenge.profarmacodechallenge.dto;

import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;

public class ProductDto {

    String productName;

    public ProductDto(ProductEntity productEntity) {
        this.productName = productEntity.getProductName();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
