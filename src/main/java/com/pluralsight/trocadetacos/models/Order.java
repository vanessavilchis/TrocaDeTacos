package com.pluralsight.trocadetacos.models;
import java.util.ArrayList;

public class Order {
    private ArrayList<MenuItem> items;

    //technically my constructor here:
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

    public Object getTotal() {
    }

    public boolean hasItems() {
    }

    public String getOrderSummary() {
    }
}
