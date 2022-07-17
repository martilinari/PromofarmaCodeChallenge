package com.profarma.challenge.profarmacodechallenge.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Optional;

@Entity
@Table(name = "seller_product")
@AssociationOverrides({@AssociationOverride(name = "primaryKey.seller", joinColumns = @JoinColumn(name = "SELLER_ID")),
        @AssociationOverride(name = "primaryKey.product", joinColumns = @JoinColumn(name = "PRODUCT_ID"))})
public class SellerProductEntity {

    // composite-id key
    private SellerProductId primaryKey = new SellerProductId();

    @Column(name = "price")
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @EmbeddedId
    public SellerProductId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(SellerProductId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public SellerEntity getSeller() {
        return getPrimaryKey().getSeller();
    }

    public void setSeller(SellerEntity seller) {
        getPrimaryKey().setSeller(seller);
    }

    @Transient
    public ProductEntity getProduct() {
        return getPrimaryKey().getProduct();
    }

    public void setProduct(ProductEntity product) {
        getPrimaryKey().setProduct(product);
    }
}
