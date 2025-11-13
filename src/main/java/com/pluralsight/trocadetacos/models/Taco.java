package com.pluralsight.trocadetacos.models;
import java.util.ArrayList;

public class Taco extends MenuItem implements Customizable {

    private String size;
    private String tortillaType;
    private ArrayList<Topping> toppings;
    private boolean isDeepFried;

    public Taco(String size, String tortillaType) {
        super(generateName(size, tortillaType));

        this.size = size;
        this.tortillaType = tortillaType;
        this.toppings = new ArrayList<>();
        this.isDeepFried = false;
    }
    private static String generateName(String size, String tortillaType) {
        return size + " Taco - " + tortillaType;
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

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" Taco - ").append(tortillaType);

        if (isDeepFried) {
            sb.append(" (DEEP FRIED)");
        }

        if (!toppings.isEmpty()) {
            sb.append(" with ");
            for (int i = 0; i < toppings.size(); i++) {
                sb.append(toppings.get(i).getName());
                if (i < toppings.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        return sb.toString();
    }
    @Override
    public String customize() {
        StringBuilder customization = new StringBuilder();
        customization.append("Taco Customization:\n");
        customization.append("  Size: ").append(size).append("\n");
        customization.append("  Tortilla: ").append(tortillaType).append("\n");
        customization.append("  Deep Fried: ").append(isDeepFried ? "Yes" : "No").append("\n");

        if (!toppings.isEmpty()) {
            customization.append("  Toppings:\n");
            for (Topping topping : toppings) {
                customization.append("    - ").append(topping.toString()).append("\n");
            }
        }

        return customization.toString();
    }
    @Override
    public double getPrice() {
        double basePrice = 0.0;
        switch (size) {
            case "Single":
                basePrice = 3.50;
                break;
            case "3-Taco":
                basePrice = 9.00;
                break;
            case "Burrito":
                basePrice = 8.50;
                break;
        }

        double toppingTotal = 0.0;
        for (Topping topping : toppings) {
            toppingTotal += topping.getPrice(size);
        }

        return basePrice + toppingTotal;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(size).append(" - ").append(tortillaType);

        if (isDeepFried) {
            sb.append(" (DEEP FRIED)");
        }

        if (!toppings.isEmpty()) {
            sb.append("\n  Toppings:");
            for (Topping topping : toppings) {
                sb.append("\n    - ").append(topping.toString());
            }
        }

        sb.append("\n  Price: $").append(String.format("%.2f", getPrice()));

        return sb.toString();
    }
}