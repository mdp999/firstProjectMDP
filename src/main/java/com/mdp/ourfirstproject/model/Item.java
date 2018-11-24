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

    private BigDecimal price;
    private BigDecimal amount;

    @Transient
    private BigDecimal fullPrice;

    @ManyToOne
    @JoinColumn(name="transaction_id", referencedColumnName = "id_transaction", nullable=false)
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id_product", nullable=false)
    private Product product;

    @Enumerated(EnumType.STRING)
    private ItemCategory itemCategory;

    public Item() {
    }


    public Item(Product product, BigDecimal price,
                BigDecimal amount, ItemCategory itemCategory) {
        this.price = price;
        this.amount = amount;
        this.product = product;
        this.itemCategory = itemCategory;
    }

    public Item(Long id, Product product, BigDecimal price,
                BigDecimal amount, ItemCategory itemCategory) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.product = product;
        this.itemCategory = itemCategory;
    }

    public Item(String name, BigDecimal price, BigDecimal amount, BigDecimal fullPrice,
                Transaction transaction, Product product, ItemCategory itemCategory) {
        this.price = price;
        this.amount = amount;
        this.fullPrice = fullPrice;
        this.transaction = transaction;
        this.product = product;
        this.itemCategory = itemCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ItemCategory getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
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
