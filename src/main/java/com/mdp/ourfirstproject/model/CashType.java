package com.mdp.ourfirstproject.model;

public enum CashType {

    CASH("Gotówka"),CARD("Karta"),ACCOUNT("Przelew");

    private String name;

    CashType(String name)
    {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

}
