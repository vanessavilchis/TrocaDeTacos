package com.pluralsight.trocadetacos.models;

public class ChipsAndSalsa {
    private String salsaType;
    private static final double PRICE = 1.50;

    public ChipsAndSalsa(String salsaType) {
        this.salsaType = salsaType;
    }

    public String getSalsaType() {
        return salsaType;
    }

    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }

    public double getPrice() {
        return PRICE;
    }

    @Override
    public String toString() {
        return "Chips & " + salsaType + " Salsa - $" + String.format("%.2f", getPrice());
    }
}