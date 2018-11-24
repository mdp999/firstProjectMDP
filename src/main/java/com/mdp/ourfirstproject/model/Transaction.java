package com.mdp.ourfirstproject.model;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "transaction")
    private List<Item> item;

    @Enumerated(EnumType.STRING)
    private CashType cashType;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Temporal(TemporalType.DATE)
    private Date transferDate;//:TODO zmienic na localDate!!!

    @Temporal(TemporalType.DATE)
    private Date creationDate;//:TODO zmienic na localDate!!!

    @Temporal(TemporalType.DATE)
    private Date modificationDate;//:TODO zmienic na localDate!!!

    public Transaction() {
    }

    public Transaction(String name, String description, CashType cashType,
                       TransactionType transactionType, Date transferDate, Date creationDate,
                       Date modificationDate) {
        this.name = name;
        this.description = description;
        this.cashType = cashType;
        this.transactionType = transactionType;
        this.transferDate = transferDate;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public Transaction(String name, String description, CashType cashType,
                       TransactionType transactionType, Date transferDate) {
        this.name = name;
        this.description = description;
        this.cashType = cashType;
        this.transactionType = transactionType;
        this.transferDate = transferDate;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public CashType getCashType() { return cashType; }

    public void setCashType(CashType cashType) { this.cashType = cashType; }

    public TransactionType getTransactionType() { return transactionType; }

    public void setTransactionType(TransactionType transactionType) { this.transactionType = transactionType; }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", name='" + name + '\'' +
                //", amount=" + amount +
                ", description='" + description + '\'' +
                ", item=" + item +
                ", transferDate=" + transferDate +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                '}';
    }

    public String toJSON()
    {
        return this.toJSON(this);
    }

    public static String toJSON(Transaction transaction)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return "{" +
                "\"Id\":\"" + transaction.getId() + '\"' +
                ", \"name\":\"" + transaction.getName() + '\"' +
                //", \"amount\":\"" + transaction.getAmount() + '\"' +
                ", \"description\":\"" + transaction.getDescription() + '\"' +
                ", \"item\":\"" + transaction.getItem() + '\"' +
                ", \"transferDate\":\"" + (transaction.getTransferDate()!=null?dateFormat.format(transaction.getTransferDate()):null) + '\"' +
                ", \"creationDate\":\"" +  (transaction.getCreationDate()!=null?dateFormat.format(transaction.getCreationDate()):null) + '\"' +
                ", \"modificationDate\":\"" +  (transaction.getModificationDate()!=null?dateFormat.format(transaction.getModificationDate()):null) + '\"' +
                '}';
    }

    public static String toJSON(List<Transaction> personList)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        personList.stream().forEach(x->sb.append(x.toJSON()).append(","));
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }
}