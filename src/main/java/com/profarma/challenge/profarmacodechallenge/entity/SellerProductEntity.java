//package com.profarma.challenge.profarmacodechallenge.entity;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.util.Set;
//
//@Entity
//@Table(name = "seller_prod")
//public class SellerProductEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "stock")
//    private Long stock;
//
//    @Column(name = "price")
//    private BigDecimal price;
////
////    @ManyToMany(cascade = CascadeType.ALL)
////    private Set<ProductEntity> product;
//
//    private SellerEntity seller;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getStock() {
//        return stock;
//    }
//
//    public void setStock(Long stock) {
//        this.stock = stock;
//    }
//
//    public BigDecimal getPrice() {
//        return price;
//    }
//
//    public void setPrice(BigDecimal price) {
//        this.price = price;
//    }
//
////    public Set<ProductEntity> getProduct() {
////        return product;
////    }
////
////    public void setProduct(Set<ProductEntity> product) {
////        this.product = product;
////    }
//
//    public Set<SellerEntity> getSeller() {
//        return seller;
//    }
//
//    public void setSeller(Set<SellerEntity> seller) {
//        this.seller = seller;
//    }
//}
