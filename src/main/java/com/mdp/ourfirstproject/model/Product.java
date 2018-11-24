package com.mdp.ourfirstproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @Column(unique = false)
    private String name;
    private BigDecimal tax;
    private String description;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private ItemCategory category;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, BigDecimal tax, String description, BigDecimal amount, ItemCategory category) {
        this.name = name;
        this.tax = tax;
        this.description = description;
        this.amount = amount;
        this.category = category;
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

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return name+" "+description;
    }
}
