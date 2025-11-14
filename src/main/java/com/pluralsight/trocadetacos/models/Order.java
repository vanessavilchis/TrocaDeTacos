package com.pluralsight.trocadetacos.models;

import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addTaco(Taco taco) {
        items.add(taco);
    }

    public void addDrink(Drink drink) {
        items.add(drink);
    }

    public void addChips(ChipsAndSalsa chipsAndSalsa) {
        items.add(chipsAndSalsa);
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public ArrayList<Taco> getTacos() {
        ArrayList<Taco> tacos = new ArrayList<>();
        for (MenuItem item : items) {
            if (item instanceof Taco) {
                tacos.add((Taco) item);
            }
        }
        return tacos;
    }

    public ArrayList<Drink> getDrinks() {
        ArrayList<Drink> drinks = new ArrayList<>();
        for (MenuItem item : items) {
            if (item instanceof Drink) {
                drinks.add((Drink) item);
            }
        }
        return drinks;
    }

    public ArrayList<ChipsAndSalsa> getChips() {
        ArrayList<ChipsAndSalsa> chips = new ArrayList<>();
        for (MenuItem item : items) {
            if (item instanceof ChipsAndSalsa) {
                chips.add((ChipsAndSalsa) item);
            }
        }
        return chips;
    }

    public double getTotal() {
        double total = 0.0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public boolean hasItems() {
        return !items.isEmpty();
    }

    public String getOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("\n==================================================\n");
        summary.append("                 📋 ORDER SUMMARY                 \n");
        summary.append("==================================================\n");

        for (int i = 0; i < items.size(); i++) {
            summary.append("\nItem ").append(i + 1).append(":\n");
            summary.append(items.get(i).toString()).append("\n");
        }

        summary.append("\n==================================================\n");
        summary.append(String.format("TOTAL: $%.2f\n", getTotal()));
        summary.append("==================================================\n");

        return summary.toString();
    }
}
