package com.mdp.ourfirstproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Item implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Long id;

    private String name;
    private BigDecimal price;
    private BigDecimal amount;

    @Transient
    private BigDecimal fullPrice;

    @ManyToOne
    @JoinColumn(name="transfer_id", referencedColumnName = "id_transfer", nullable=false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id_product", nullable=false)
    private Product product;

    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

    public Item() {
    }

    public Item(String name, BigDecimal price, BigDecimal amount, BigDecimal fullPrice,
                Transaction transaction, Product product, ProductCategory productCategory) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.fullPrice = fullPrice;
        this.transaction = transaction;
        this.product = product;
        this.productCategory = productCategory;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getFullPrice() {
        return amount.multiply(price);
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return product+" "+price+"x"+amount+"  "+fullPrice;
    }
}
