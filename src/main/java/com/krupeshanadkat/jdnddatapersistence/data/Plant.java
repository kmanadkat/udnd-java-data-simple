package com.krupeshanadkat.jdnddatapersistence.data;

import jakarta.persistence.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plant {
    @Id
    @GeneratedValue
    private Long id;

    @Nationalized
    private String name;

    @Column(precision = 12, scale = 4)
    private BigDecimal price;

    @ManyToOne //many plants can belong to one delivery
    @JoinColumn(name = "delivery_id")  //map the join column in the plant table
    private Delivery delivery;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
