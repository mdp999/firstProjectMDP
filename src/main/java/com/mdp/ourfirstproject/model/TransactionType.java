package com.mdp.ourfirstproject.model;

public enum TransactionType {

    EXPENDITURE("Expenditure"),INCOME("Income");

    private String name;

    TransactionType(String name)
    {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
