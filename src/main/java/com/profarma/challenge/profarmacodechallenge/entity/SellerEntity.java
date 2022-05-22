package com.profarma.challenge.profarmacodechallenge.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "seller")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(length = 60, unique = true)
    private String email;


    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name = "seller_product", joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sellerId", referencedColumnName = "id"))
    private Set<ProductEntity> products = new HashSet<ProductEntity>();

    public SellerEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
