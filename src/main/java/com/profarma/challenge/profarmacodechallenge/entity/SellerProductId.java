package com.profarma.challenge.profarmacodechallenge.entity;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class SellerProductId implements Serializable {
    private SellerEntity seller;
    private ProductEntity product;

    @ManyToOne(cascade = CascadeType.ALL)
    public SellerEntity getSeller() {
        return seller;
    }

    public void setSeller(SellerEntity seller) {
        this.seller = seller;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
