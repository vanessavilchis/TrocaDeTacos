package com.pluralsight.trocadetacos.ui;

import com.pluralsight.trocadetacos.models.Order;
import java.util.Scanner;

public class HomeScreen {
    private Scanner scanner;

    public HomeScreen(Scanner scanner) {
        this.scanner = scanner;
    }
    public void display() {
        boolean running = true;

        while (running) {
            System.out.println("==================================================");
            System.out.println("     🌮 WELCOME TO TROCA DE TACOS 🌮");
            System.out.println("==================================================");
            System.out.println("\nWhat would you like to do?");
            System.out.println("[1] New Order");
            System.out.println("[0] Exit");
            System.out.print("\nEnter your choice: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1":
                    Order newOrder = new Order();
                    OrderScreen orderScreen = new OrderScreen(scanner, newOrder);
                    orderScreen.display();
                    break;
                case "0":
                    System.out.println("\n👋 Gracias for visiting La Troca De Tacos!");
                    System.out.println("¡Hasta luego Amigo! 🌮\n");
                    running = false;
                    break;
                default:
                    System.out.println("\n Invalid choice :( Please enter 1 or 0.");
            }
        }
    }
}