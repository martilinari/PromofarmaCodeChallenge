package com.profarma.challenge.profarmacodechallenge.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class SellerProductDto {

    @NotNull
    private Long productId;
    @Min(1)
    private BigDecimal price;

}
