package com.profarma.challenge.profarmacodechallenge.dto;

import com.profarma.challenge.profarmacodechallenge.entity.SellerEntity;

public class SellerDto {

    String name;
    String email;

    public SellerDto(SellerEntity sellerEntity) {
        this.name = sellerEntity.getName();
        this.email = sellerEntity.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
