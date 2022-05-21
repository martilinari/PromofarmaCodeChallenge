package com.profarma.challenge.profarmacodechallenge.entity;

import javax.persistence.*;

@Entity
@Table(name = "seller")
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellerId;

    @Column(name = "name")
    private String name;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "profesor_id", referencedColumnName = "id")
//    private List<ProductEntity> listCursos = new ArrayList<>();

    public SellerEntity() {

    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
