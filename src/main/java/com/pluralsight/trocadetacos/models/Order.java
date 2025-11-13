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
}