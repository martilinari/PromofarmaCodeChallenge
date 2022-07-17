package com.profarma.challenge.profarmacodechallenge.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

//    @Column(name = "sellerId")
//    private Long sellerId;


//    @ManyToMany(cascade = CascadeType.ALL)
//    @JsonBackReference
//    @JoinTable(name = "seller_product", joinColumns = @JoinColumn(name = "sellerId", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "productId", referencedColumnName = "id"))
//    private Set<SellerEntity> lenguajes = new HashSet<SellerEntity>();

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
//
//    public Long getSellerId() {
//        return sellerId;
//    }
//
//    public void setSellerId(Long sellerId) {
//        this.sellerId = sellerId;
//    }

}
