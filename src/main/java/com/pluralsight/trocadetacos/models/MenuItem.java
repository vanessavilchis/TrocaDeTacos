package com.pluralsight.trocadetacos.models;

public abstract class MenuItem implements Priceable {
    protected String name;

    public MenuItem(String name) {
        this.name = name;
    }

    public abstract String getDescription();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println(getDescription());
        System.out.printf("Price: $%.2f%n", getPrice());
    }
}