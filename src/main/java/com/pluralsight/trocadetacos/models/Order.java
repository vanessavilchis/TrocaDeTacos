package com.pluralsight.trocadetacos.models;
import java.util.ArrayList;

public class Order {
    private ArrayList<Taco> tacos;
    private ArrayList<Drink> drinks;
    private ArrayList<ChipsAndSalsa> chips;

    public Order() {
        this.tacos = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }
    public ArrayList<Taco> getTacos() {
        return tacos;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<ChipsAndSalsa> getChips() {
        return chips;
    }

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(ChipsAndSalsa chipsAndSalsa) {
        chips.add(chipsAndSalsa);
    }

    public void removeTaco(int index) {
        if (index >= 0 && index < tacos.size()) {
            tacos.remove(index);
        }
    }

    public void removeDrink(int index) {
        if (index >= 0 && index < drinks.size()) {
            drinks.remove(index);
        }
    }

    public void removeChips(int index) {
        if (index >= 0 && index < chips.size()) {
            chips.remove(index);
        }
    }
    public void clearOrder() {
        tacos.clear();
        drinks.clear();
        chips.clear();

    }
    public boolean hasItems() {
        return !tacos.isEmpty() || !drinks.isEmpty() || !chips.isEmpty();
    }
    public double getTotal() {
        double total = 0.0;
        for (Taco taco : tacos) {
            total += taco.getPrice();
        }
        for (Drink drink : drinks) {
            total += drink.getPrice();
        }
        for (ChipsAndSalsa chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }
    public String getOrderSummary() {
        StringBuilder sb = new StringBuilder();
        System.out.println("==================================================");
        sb.append("                          ORDER SUMMARY\n");
        System.out.println("==================================================");

        if (!tacos.isEmpty()) {
            sb.append("TACOS:\n");
            for (int i = 0; i < tacos.size(); i++) {
                sb.append((i + 1)).append(". ");
                sb.append(tacos.get(i).toString()).append("\n\n");
            }
        }

        if (!drinks.isEmpty()) {
            sb.append("DRINKS:\n");
            for (int i = 0; i < drinks.size(); i++) {
                sb.append((i + 1)).append(". ");
                sb.append(drinks.get(i).toString()).append("\n");
            }
            sb.append("\n");
        }

        if (!chips.isEmpty()) {
            sb.append("CHIPS & SALSA:\n");
            for (int i = 0; i < chips.size(); i++) {
                sb.append((i + 1)).append(". ");
                sb.append(chips.get(i).toString()).append("\n");
            }
            sb.append("\n");
        }

        System.out.println("==================================================");
        sb.append(String.format("         TOTAL:  $%.2f\n", getTotal()));
        System.out.println("==================================================");

        return sb.toString();
    }

    @Override
    public String toString() {
        return getOrderSummary();
    }
}

