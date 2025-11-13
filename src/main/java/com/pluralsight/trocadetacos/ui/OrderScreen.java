package com.pluralsight.trocadetacos.ui;
import com.pluralsight.trocadetacos.models.*;
import com.pluralsight.trocadetacos.services.ReceiptService;
import java.util.Scanner;

public class OrderScreen {
    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner, Order order) {
        this.scanner = scanner;
        this.order = order;
    }

    public void display() {
        boolean ordering = true;
        while (ordering) {
            System.out.println("==================================================");
            System.out.println("                 📋 ORDER HERE                    ");
            System.out.println("==================================================");
            int itemCount = order.getItems().size();
            System.out.println("\nCurrent items in order: " + itemCount);
            if (itemCount > 0) {
                System.out.printf("Current total: $%.2f\n", order.getTotal());
            }
            System.out.println("\nWhat would you like to do?");
            System.out.println(" [1] Add Taco");
            System.out.println(" [2] Add Drink");
            System.out.println(" [3] Add Chips & Salsa");
            System.out.println(" [4] Checkout");
            System.out.println(" [0] Cancel Order");
            System.out.print("\nEnter your choice here : ");
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


