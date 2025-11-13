package com.pluralsight.trocadetacos.models;

public class Topping {
    private String name;
    private String category;
    private boolean isExtra;

    public Topping(String name, String category) {
        this.name = name;
        this.category = category;
        this.isExtra = false;
    }

    public Topping(String name, String category, boolean isExtra) {
        this.name = name;
        this.category = category;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public void setExtra(boolean extra) {
        isExtra = extra;
    }

    public double getPrice(String tacoSize) {
        if (category.equals("REGULAR") || category.equals("SAUCE")) {
            return 0.0;
        }
        double basePrice = 0.0;
        double extraPrice = 0.0;

        if (category.equals("MEAT")) {
            switch (tacoSize) {
                case "Single":
                    basePrice = 1.00;
                    extraPrice = 0.50;
                    break;
                case "3 Taco":
                    basePrice = 2.00;
                    extraPrice = 1.00;
                    break;
                case "Burrito":
                    basePrice = 3.00;
                    extraPrice = 1.50;
                    break;
            }
        } else if (category.equals("CHEESE")) {
            switch (tacoSize) {
                case "Single":
                    basePrice = 0.75;
                    extraPrice = 0.30;
                    break;
                case "3 Taco":
                    basePrice = 1.50;
                    extraPrice = 0.60;
                    break;
                case "Burrito":
                    basePrice = 2.25;
                    extraPrice = 0.90;
                    break;
            }
        }
        return isExtra ? (basePrice + extraPrice) : basePrice;
    }
    }
}

