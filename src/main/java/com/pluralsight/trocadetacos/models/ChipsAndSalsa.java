package com.pluralsight.trocadetacos.models;

public class ChipsAndSalsa {
    private String salsaType;
    private static final double price = 1.50;

    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }

    public String getSalsaType() {
        return salsaType;
    }

    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }
}