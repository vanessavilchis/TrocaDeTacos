package com.pluralsight.trocadetacos;

import com.pluralsight.trocadetacos.ui.HomeScreen;

import java.util.Scanner;

public class TrocadeTacosApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String RESET = "\u001B[0m";
        final String GREEN = "\u001B[32m";
        final String WHITE = "\u001B[37m";
        final String RED = "\u001B[31m";

        System.out.println("\n");
        System.out.println(GREEN + "=====================================================" + RESET);
        System.out.println(WHITE + "        🚚💨  LA TROCA DE TACOS  🚚💨" + RESET);
        System.out.println(RED + "=====================================================" + RESET);
        System.out.println();
        System.out.println(WHITE + " 🌵 Fresh • Fast • Fiesta 🌵 |  🇲🇽  Authentic Tacos " + RESET);
        System.out.println(GREEN + "=====================================================" + RESET);
        HomeScreen homeScreen = new HomeScreen(scanner);
        homeScreen.display();
        scanner.close();

    }
}