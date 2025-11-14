package com.pluralsight.trocadetacos.ui;
import com.pluralsight.trocadetacos.models.*;
import com.pluralsight.trocadetacos.services.ReceiptService;
import java.util.Scanner;

public class OrderScreen implements Displayable {
    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }
    @Override
    public void display() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("==================================================");
            System.out.println("                 📋 ORDER HERE                    ");
            System.out.println("==================================================");

            int itemCount = order.getTacos().size() + order.getDrinks().size() + order.getChips().size();
            System.out.println("\nCurrent items in order: " + itemCount);
            if (itemCount > 0) {
                System.out.printf("Current total: $%.2f\n", order.getTotal());
            }
            System.out.println("\nWhat would you like?");
            System.out.println(" [1] Add Entree ");
            System.out.println(" [2] Add Drink");
            System.out.println(" [3] Add Chips & Salsa");
            System.out.println(" [4] Checkout");
            System.out.println(" [0] Cancel Order");
            System.out.print("\nSelect a menu option here: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addTaco();
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
                    ordering = false;
                    break;
                case "0":
                    if (confirmCancel()) {
                        System.out.println("\n Order cancelled :( ");
                        ordering = false;
                    }
                    break;
                default:
                    System.out.println("\n Sorry that's an invalid choice. Please try again.");
            }
        }
    }

    private void addTaco() {
        TacoScreen tacoScreen = new TacoScreen(scanner);
        Taco newTaco = tacoScreen.buildTaco();
        if (newTaco != null) {
            order.addTaco(newTaco);
            System.out.println("\n YAY! Taco added to your order!");
            System.out.println(newTaco);
        }
    }

    private void addDrink() {
        System.out.println("==================================================");
        System.out.println("                   🥤 ADD DRINK                   ");
        System.out.println("==================================================");

        System.out.println("\nSTEP 1: Select drink size");
        System.out.println("1) Small - $2.00");
        System.out.println("2) Medium - $2.50");
        System.out.println("3) Large - $3.00");
        System.out.println("0) Cancel");
        System.out.print("\nEnter choice: ");

        String sizeChoice = scanner.nextLine();
        String size = null;
        switch (sizeChoice) {
            case "1":
                size = "Small";
                break;
            case "2":
                size = "Medium";
                break;
            case "3":
                size = "Large";
                break;
            case "0":
                System.out.println("\nDrink order cancelled.");
                return;
            default:
                System.out.println("\nInvalid choice. You get a Small.");
                size = "Small";
        }
        System.out.println("==================================================");
        System.out.println("                   DRINK MENU                     ");
        System.out.println("           TRY OUR AGUA FRESCAS!                  ");
        System.out.println("==================================================");
        System.out.println("\n What flavor drink would you like?");
        System.out.println("[1] Coke");
        System.out.println("[2] Pepsi");
        System.out.println("[3] Sprite");
        System.out.println("[4] Lemonade");
        System.out.println("[5] Iced Tea");
        System.out.println("[6] Horchata");
        System.out.println("[7] Aqua de Jamaica (Hibiscus Tea)");
        System.out.println("[8] Tamarindo ");
        System.out.println("[0] Cancel");
        System.out.print("\nEnter your choice here: ");

        String flavorChoice = scanner.nextLine().trim();
        String flavor = null;

        switch (flavorChoice) {
            case "1":
                flavor = "Coke";
                break;
            case "2":
                flavor = "Pepsi";
                break;
            case "3":
                flavor = "Sprite";
                break;
            case "4":
                flavor = "Lemonade";
                break;
            case "5":
                flavor = "Iced Tea";
                break;
            case "6":
                flavor = "Horchata";
                break;
            case "7":
                flavor = "Jamaica";
                break;
            case "8":
                flavor = "Tamarindo";
                break;
            case "0":
                System.out.println("\n Drink order cancelled.");
                return;
            default:
                System.out.println("\n️ Invalid choice. Defaulting to Coke.");
                flavor = "Coke";
        }
        Drink newDrink = new Drink(size, flavor);
        order.addDrink(newDrink);
        System.out.println("\nDrink added to order!");
        System.out.println(newDrink);
    }

    private void addChips() {
        System.out.println("==================================================");
        System.out.println("             🌶️ ADD CHIPS & SALSA 💃🏻             ");
        System.out.println("==================================================");

        System.out.println("\nSelect salsa type - $1.50");
        System.out.println("[1] Salsa Verde");
        System.out.println("[2] Salsa Roja");
        System.out.println("[3] Pico de Gallo");
        System.out.println("[4] Chipotle Salsa");
        System.out.println("[5] Habanero Salsa");
        System.out.println("[6] Mango Salsa");
        System.out.println("[0] Cancel");
        System.out.print("\nEnter choice: ");

        String choice = scanner.nextLine().trim();
        String salsaType = null;

        switch (choice) {
            case "1":
                salsaType = "Verde";
                break;
            case "2":
                salsaType = "Roja";
                break;
            case "3":
                salsaType = "Pico de Gallo";
                break;
            case "4":
                salsaType = "Chipotle";
                break;
            case "5":
                salsaType = "Habanero";
                break;
            case "6":
                salsaType = "Mango";
                break;
            case "0":
                System.out.println("\nChips & Salsa order cancelled.");
                return;
            default:
                System.out.println("\n️ Invalid choice. Defaulting to Verde on the side");
                salsaType = "Verde on the side";
        }
        ChipsAndSalsa newChips = new ChipsAndSalsa(salsaType);
        order.addChips(newChips);
        System.out.println("\nChips & Salsa added to order!");
        System.out.println(newChips);
    }

    private void checkout() {
        if (!order.hasItems()) {
            System.out.println("\nUh Oh! looks like your order is empty! Please add items before checking out.");
            return;
        }
        System.out.println("\n" + order.getOrderSummary());
        System.out.print("Confirm checkout? (Y/N): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if (confirm.equals("y") || confirm.equals("yes")) {
            ReceiptService receiptService = new ReceiptService();
            String filename = receiptService.saveReceipt(order);

            if (filename != null) {
                System.out.println("\n✅ Order complete! 💃🏻 ");
                System.out.println("Receipt saved");
                System.out.println("\n🌮 Thank you for your order! 🌮\n");
                System.out.println(" Your order will be out shortly! Enjoy! ");
            } else {
                System.out.println("\n Warning! Receipt could not be saved, but order has been submitted!");
                System.out.println("\n Your order will be out shortly!");
            }
        } else {
            System.out.println("\n Checkout cancelled. You can continue adding items.");
        }
    }
    private boolean confirmCancel() {
        if (!order.hasItems()) {
            return true;
        }
        System.out.print("\n Are you sure you want to cancel this order? (Y/N): ");
        String confirm = scanner.nextLine().trim().toLowerCase();
        return confirm.equals("y") || confirm.equals("yes");
    }
}
