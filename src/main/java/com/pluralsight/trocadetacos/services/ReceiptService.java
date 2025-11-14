package com.pluralsight.trocadetacos.services;

import com.pluralsight.trocadetacos.models.Order;
import com.pluralsight.trocadetacos.models.Taco;
import com.pluralsight.trocadetacos.models.Drink;
import com.pluralsight.trocadetacos.models.ChipsAndSalsa;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ReceiptService {
    private static final String RECEIPT_FOLDER = "receipts";

    public ReceiptService() {
    }

    public String saveReceipt(Order order) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

        String timestamp = now.format(dateTimeFormatter);
        String filename = RECEIPT_FOLDER + "/" + timestamp + ".txt";

        try (
                FileWriter fileWriter = new FileWriter(filename);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            bufferedWriter.write("==================================================\n");
            bufferedWriter.write("           LA TRUCKA DE TACOS\n");
            bufferedWriter.write("        Fresh • Fast • Fiesta\n");
            bufferedWriter.write("==================================================\n");
            bufferedWriter.write("\n");

            DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
            String displayTime = now.format(displayFormatter);

            bufferedWriter.write("Date: " + displayTime + "\n");
            bufferedWriter.write("\n");

            if (!order.getTacos().isEmpty()) {
                bufferedWriter.write("TACOS:\n");
                for (Taco taco : order.getTacos()) {
                    bufferedWriter.write(taco.toString() + "\n");
                    bufferedWriter.write("\n");
                }
            }

            if (!order.getDrinks().isEmpty()) {
                bufferedWriter.write("DRINKS:\n");
                for (Drink drink : order.getDrinks()) {
                    bufferedWriter.write(drink.toString() + "\n");
                }
                bufferedWriter.write("\n");
            }

            if (!order.getChips().isEmpty()) {
                bufferedWriter.write("CHIPS & SALSA:\n");
                for (ChipsAndSalsa chips : order.getChips()) {
                    bufferedWriter.write(chips.toString() + "\n");
                }
                bufferedWriter.write("\n");
            }

            bufferedWriter.write("==================================================\n");
            bufferedWriter.write(String.format("TOTAL: $%.2f\n", order.getTotal()));
            bufferedWriter.write("==================================================\n");
            bufferedWriter.write("\n");
            bufferedWriter.write("          Thank you for your order!\n");
            bufferedWriter.write("            ¡Hasta luego! 🌮\n");
            bufferedWriter.write("\n");
            bufferedWriter.write("==================================================\n");

            System.out.println("Receipt saved successfully!");
            return filename;

        } catch (IOException exception) {
            System.out.println(" Error Writing Receipt: " + exception.getMessage());
            exception.printStackTrace();
            return null;
        }
    }
}
