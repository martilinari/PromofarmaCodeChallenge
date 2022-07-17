package com.profarma.challenge.profarmacodechallenge.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductDto {

    @NotNull
    private Long id;
    @NotNull
    private String productName;

}
