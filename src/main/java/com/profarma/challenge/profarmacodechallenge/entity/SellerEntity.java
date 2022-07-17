package com.profarma.challenge.profarmacodechallenge.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "seller")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seller_name")
    private String sellerName;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "sellerId", referencedColumnName = "id")
//    private List<ProductEntity> listProducts = new ArrayList<>();

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JsonBackReference
//    @JoinTable(name = "seller_product", joinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "sellerId", referencedColumnName = "id"))
//    private Set<ProductEntity> products = new HashSet<ProductEntity>();

//    public SellerEntity() {
//
//    }
//
//    public List<ProductEntity> getListProducts() {
//        return listProducts;
//    }
//
//    public void setListProducts(List<ProductEntity> listProducts) {
//        this.listProducts = listProducts;
//    }
//

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
