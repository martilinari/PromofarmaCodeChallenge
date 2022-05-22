package com.profarma.challenge.profarmacodechallenge.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "seller_product", joinColumns = @JoinColumn(name = "sellerId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"))
    private Set<SellerEntity> lenguajes = new HashSet<SellerEntity>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Set<SellerEntity> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(Set<SellerEntity> lenguajes) {
        this.lenguajes = lenguajes;
    }
}
