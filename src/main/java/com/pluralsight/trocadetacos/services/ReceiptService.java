package com.pluralsight.trocadetacos.services;

import com.pluralsight.trocadetacos.models.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptService {
    private static final String RECEIPT_FOLDER = "RECEIPT_FOLDER";

    public String saveReceipt(Order order) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = now.format(dateTimeFormatter);
        String filename = RECEIPT_FOLDER + "/" + timestamp + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write("====================================================\n");
            writer.write("          🚚💨 TRUCKA DE TACOS 🚚💨\n");
            writer.write("====================================================\n");
            writer.write("         Fresh • Fast • Fiesta 🌵\n");
            writer.write("====================================================\n\n");

            DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            writer.write("Date: " + now.format(displayFormatter) + "\n");
            writer.write("Order #: " + timestamp + "\n\n");

            writer.write("====================================================\n");
            writer.write("                   ORDER ITEMS\n");
            writer.write("====================================================\n\n");


            int itemNumber = 1;
            for (MenuItem item : order.getItems()) {
                writer.write("Item " + itemNumber + ":\n");
                writer.write(item.toString() + "\n\n");
                itemNumber++;
            }

            writer.write("====================================================\n");
            writer.write(String.format("TOTAL:                                    $%.2f\n", order.getTotal()));
            writer.write("====================================================\n\n");

            writer.write("       🌮 Thank you for your order! 🌮\n");
            writer.write("         ¡Que aproveche! Enjoy!\n\n");

            return filename;

        } catch (IOException e) {
            System.err.println("Error saving receipt: " + e.getMessage());
            return null;
        }
    }
}
