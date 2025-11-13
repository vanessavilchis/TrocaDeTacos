package com.pluralsight.trocadetacos.models;

public class Drink extends MenuItem implements Customizable {

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        super(size + " " + flavor);
        this.flavor = flavor;
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }
    @Override
    public String getDescription() {
        return size + " " + flavor;
    }
    @Override
    public String customize() {
        StringBuilder customization = new StringBuilder();
        customization.append("Drink Customization:\n");
        customization.append("  Size: ").append(size).append("\n");
        customization.append("  Flavor: ").append(flavor).append("\n");
        return customization.toString();
    }
    public double getPrice() {
        switch (size) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
            default:
                return 2.00;
        }
    }
    @Override
    public String toString() {
        return size + " " + flavor + " - $" + String.format("%.2f", getPrice());
    }
}
