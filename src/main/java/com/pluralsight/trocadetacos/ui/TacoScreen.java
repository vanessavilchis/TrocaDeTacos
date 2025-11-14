package com.pluralsight.trocadetacos.ui;

import com.pluralsight.trocadetacos.models.Taco;
import com.pluralsight.trocadetacos.models.Topping;

import java.util.Scanner;

public class TacoScreen {
    private Scanner scanner;

    public TacoScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Taco buildTaco() {
        System.out.println("==================================================");
        System.out.println("                  🌮 BUILD YOUR TACO              ");
        System.out.println("==================================================");
        System.out.println("\nSTEP 1: Select taco size");
        System.out.println("[1] Single Taco - $3.50");
        System.out.println("[2] 3-Taco Plate - $9.00");
        System.out.println("[3] Burrito - $8.50");
        System.out.println("[0] Cancel");
        System.out.print("\nEnter choice: ");

        String sizeChoice = scanner.nextLine().trim();
        String size = null;

        switch (sizeChoice) {
            case "1":
                size = "Single";
                break;
            case "2":
                size = "3-Taco";
                break;
            case "3":
                size = "Burrito";
                break;
            case "0":
                System.out.println("\nTaco order cancelled.");
                return null;
            default:
                System.out.println("\n That's not a valid choice - You get one taco.");
                size = "Single";
        }
        System.out.println("\nSTEP 2: Select tortilla type");
        System.out.println("[1] Corn Tortilla");
        System.out.println("[2] Flour Tortilla");
        System.out.println("[3] Hard Shell");
        System.out.println("[4] Bowl  ");
        System.out.println("[0] Cancel");
        System.out.print("\nSelect a number choice: ");

        String tortillaChoice = scanner.nextLine().trim();
        String tortilla = null;

        switch (tortillaChoice) {
            case "1":
                tortilla = "Corn";
                break;
            case "2":
                tortilla = "Flour";
                break;
            case "3":
                tortilla = "Hard Shell";
                break;
            case "0":
                System.out.println("\nOh No! Taco order cancelled.");
                return null;
            default:
                System.out.println("\n Not a valid choice, Defaulting to Corn.");
                tortilla = "Corn";
        }

        Taco taco = new Taco(size, tortilla);
        addMeat(taco);
        addCheese(taco);
        addRegularToppings(taco);
        addSalsas(taco);


        if (!size.equals("Burrito")) {
            System.out.println("\nWould you like it deep fried? (Y/N): ");
            String deepFryChoice = scanner.nextLine().trim().toLowerCase();
            if (deepFryChoice.equals("y") || deepFryChoice.equals("yes")) {
                taco.setDeepFried(true);
                System.out.println("Okayyy sure, Making it crispy!");
            }
        }

        return taco;
    }

    private void addMeat(Taco taco) {
        System.out.println("\n==================================================");
        System.out.println("                  SELECT MEAT                      ");
        System.out.println("==================================================");
        System.out.println("[1] Carne Asada (Grilled Beef)");
        System.out.println("[2] Pollo (Chicken)");
        System.out.println("[3] Carnitas (Braised Pork)");
        System.out.println("[4] Al Pastor (Marinated Pork)");
        System.out.println("[5] Chorizo (Spicy Sausage)");
        System.out.println("[6] Pescado (Fish)");
        System.out.println("[0] No meat");
        System.out.print("\nSelect a number choice: ");

        String choice = scanner.nextLine().trim();
        String meat = null;

        switch (choice) {
            case "1":
                meat = "Carne Asada";
                break;
            case "2":
                meat = "Pollo";
                break;
            case "3":
                meat = "Carnitas";
                break;
            case "4":
                meat = "Al Pastor";
                break;
            case "5":
                meat = "Chorizo";
                break;
            case "6":
                meat = "Pescado";
                break;
            case "0":
                return;
            default:
                System.out.println("\n Invalid choice. Skipping meat. You're Vegeterian Now");
                return;
        }
        Topping meatTopping = new Topping(meat, "MEAT");
        taco.addTopping(meatTopping);

        System.out.print("Would you like EXTRA " + meat + "? (Y/N): ");
        String extraChoice = scanner.nextLine().trim().toLowerCase();
        if (extraChoice.equals("y") || extraChoice.equals("yes")) {
            meatTopping.setExtra(true);
            System.out.println(" Extra Protein added!");
        }
    }
    private void addCheese(Taco taco) {
        System.out.println("\n==================================================");
        System.out.println("            CHEESE IS EXTRA +$0.75+)               ");
        System.out.println("==================================================");
        System.out.println("[1] Queso Fresco");
        System.out.println("[2] Cheddar");
        System.out.println("[3] Monterey Jack");
        System.out.println("[4] Cotija");
        System.out.println("[0] No cheese");
        System.out.print("\nEnter choice: ");

        String choice = scanner.nextLine().trim();
        String cheese = null;

        switch (choice) {
            case "1":
                cheese = "Queso Fresco";
                break;
            case "2":
                cheese = "Cheddar";
                break;
            case "3":
                cheese = "Monterey Jack";
                break;
            case "4":
                cheese = "Cotija";
                break;
            case "0":
                return;
            default:
                System.out.println("\nInvalid option - Skipping cheese");
                return;
        }

        Topping cheeseTopping = new Topping(cheese, "CHEESE");
        taco.addTopping(cheeseTopping);

        System.out.print("Would you like EXTRA " + cheese + "? (Y/N): ");
        String extraChoice = scanner.nextLine().trim().toLowerCase();
        if (extraChoice.equals("y") || extraChoice.equals("yes")) {
            cheeseTopping.setExtra(true);
            System.out.println("Extra cheese added!");
        }
    }

    private void addRegularToppings(Taco taco) {
        System.out.println("\n==================================================");
        System.out.println("          Let's add some toppings now!(FREE!)      ");
        System.out.println("              Yes even the guacamole ;)            ");
        System.out.println("==================================================");
        System.out.println("Select all that apply (enter numbers separated by spaces)");
        System.out.println("[1] Lettuce");
        System.out.println("[2] Tomatoes");
        System.out.println("[3] Onions");
        System.out.println("[4] Cilantro");
        System.out.println("[5] Jalapeños");
        System.out.println("[6] Black Beans");
        System.out.println("[7] Refried Beans");
        System.out.println("[8] Rice");
        System.out.println("[9] Guacamole");
        System.out.println("[10] Sour Cream");
        System.out.println("[0] Done / No toppings");
        System.out.print("\nEnter choices: ");

        String input = scanner.nextLine().trim();
        if (input.equals("0") || input.isEmpty()) {
            return;
        }

        String[] choices = input.split("\\s+");
        for (String choice : choices) {
            String topping = null;
            switch (choice) {
                case "1":
                    topping = "Lettuce";
                    break;
                case "2":
                    topping = "Tomatoes";
                    break;
                case "3":
                    topping = "Onions";
                    break;
                case "4":
                    topping = "Cilantro";
                    break;
                case "5":
                    topping = "Jalapeños";
                    break;
                case "6":
                    topping = "Black Beans";
                    break;
                case "7":
                    topping = "Refried Beans";
                    break;
                case "8":
                    topping = "Rice";
                    break;
                case "9":
                    topping = "Guacamole";
                    break;
                case "10":
                    topping = "Sour Cream";
                    break;
            }

            if (topping != null) {
                taco.addTopping(new Topping(topping, "REGULAR"));
                System.out.println("✓ " + topping + " added!");
            }
        }
    }

    private void addSalsas(Taco taco) {
        System.out.println("\n==================================================");
        System.out.println("            🌶️ SALSAS!  (FREE!) 💃🏻                  ");
        System.out.println("==================================================");
        System.out.println("Select all that apply (enter numbers separated by spaces)");
        System.out.println("[1] Salsa Verde");
        System.out.println("[2] Salsa Roja");
        System.out.println("[3] Pico de Gallo");
        System.out.println("[4] Chipotle Sauce");
        System.out.println("[5] Habanero Sauce (MUY CALIENTE)");
        System.out.println("[6] Lime Crema");
        System.out.println("[0] Done / No sauce");
        System.out.print("\nEnter choices: ");

        String input = scanner.nextLine();
        if (input.equals("0") || input.isEmpty()) {
            return;
        }

        String[] choices = input.split("\\s+");
        for (String choice : choices) {
            String salsa = null;
            switch (choice) {
                case "1":
                    salsa = "Salsa Verde";
                    break;
                case "2":
                    salsa = "Salsa Roja";
                    break;
                case "3":
                    salsa = "Pico de Gallo";
                    break;
                case "4":
                    salsa = "Chipotle Sauce";
                    break;
                case "5":
                    salsa = "Habanero Sauce";
                    break;
                case "6":
                    salsa = "Lime Crema";
                    break;
            }

            if (salsa != null) {
                taco.addTopping(new Topping(salsa, "SALSA"));
                System.out.println("💃🏻" + salsa + " added!");
            }
        }
    }
}
