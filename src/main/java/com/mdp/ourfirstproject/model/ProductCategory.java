package com.mdp.ourfirstproject.model;

public enum ProductCategory {

    GIFTS("Dary"), TAXES("Podatki"), TEMPORAL("Okresowe"), HOUSECARE("Utrzymanie domu"),
    FOOD("Pożywienie"), ADDICTIONS("Nałogowe"), TRANSPORT("Transport"), INSURANCE("Ubezpieczenie"),
    DEBTS("Długi"), ENTERTAINMENT("Rozrywki"), CLOTHINGS("Odzież"), HEALTCARE("Koszty leczenia"),
    OTHERS("Inne"), INVESTMENTS("Inwestycje"), EDUCATION("Edukacja"), PERSONAL("Osobiste");

    private String name;

    ProductCategory(String name)
    {
        this.name = name;
    }

    public String getValue() {
        return name;
    }

}
