package com.profarma.challenge.profarmacodechallenge.mapper;

import com.profarma.challenge.profarmacodechallenge.dto.ProductDto;
import com.profarma.challenge.profarmacodechallenge.dto.SellerDto;
import com.profarma.challenge.profarmacodechallenge.entity.ProductEntity;
import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("Mapper")
public class Mapper {

    public SellerDto convertSeller(SellerEntity sellerEntity) {
        return new SellerDto(sellerEntity);
    }

    public ProductDto convertProduct(ProductEntity productEntity) {
        return new ProductDto(productEntity);
    }

    public List<SellerDto> convertListSeller(List<SellerEntity> sellerList) {
        List<SellerDto> sellerDtoList = new ArrayList<>();
        sellerList.stream().forEach((sellers) -> {
            sellerDtoList.add(new SellerDto(sellers));
        });
        return sellerDtoList;
    }

    public List<ProductDto> convertListProduct(List<ProductEntity> productList) {
        List<ProductDto> productDtoList = new ArrayList<>();
        productList.stream().forEach((sellers) -> {
            productDtoList.add(new ProductDto(sellers));
        });
        return productDtoList;
    }

}
