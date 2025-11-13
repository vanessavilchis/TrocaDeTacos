package com.pluralsight.trocadetacos.models;

public class ChipsAndSalsa extends MenuItem implements Customizable {

    private String salsaType;
    private static final double price = 1.50;

    public ChipsAndSalsa(String salsaType) {
        super("Chips & " + salsaType + " Salsa");
        this.salsaType = salsaType;
    }
    public String getSalsaType() {
        return salsaType;
    }
    public void setSalsaType(String salsaType) {
        this.salsaType = salsaType;
    }
    public double getPrice() {
        return price;
    }
    @Override
    public String getDescription() {
        return "Chips & " + salsaType + " Salsa";
    }
    @Override
    public String customize() {
        StringBuilder customization = new StringBuilder();
        customization.append("Chips & Salsa Customization:\n");
        customization.append("  Salsa Type: ").append(salsaType).append("\n");
        customization.append("  Price: $").append(String.format("%.2f",price)).append("\n");
        return customization.toString();
    }
    @Override
    public String toString() {
        return "Chips & " + salsaType + " Salsa - $" + String.format("%.2f", getPrice());
    }
}