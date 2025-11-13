package com.pluralsight.trocadetacos.models;
import java.util.ArrayList;

public class Taco {
    private String size;
    private String tortillaType;
    private ArrayList<Topping> toppings;
    private boolean isDeepFried;

    public Taco(String size, String tortillaType) {
        this.size = size;
        this.tortillaType = tortillaType;
        this.toppings = new ArrayList<>();
        this.isDeepFried = false;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTortillaType() {
        return tortillaType;
    }

    public void setTortillaType(String tortillaType) {
        this.tortillaType = tortillaType;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public boolean isDeepFried() {
        return isDeepFried;
    }

    public void setDeepFried(boolean deepFried) {
        isDeepFried = deepFried;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    public void clearToppings() {
        toppings.clear();
    }

    public double getPrice() {

        double basePrice = 0.0;
        switch (size) {
            case "Single":
                basePrice = 3.50;
                break;
            case "3 Taco":
                basePrice = 9.00;
                break;
            case "Burrito":
                basePrice = 8.50;
                break;
        }
    }
}