package com.example.pc;

import java.util.Scanner;

public class PersonalComputerApp {

    public static void main(String[] args) {
        new PersonalComputerApp().start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        PCBuilder builder = new PCBuilder();
        Director director = new Director(builder);
        InMemoryLogger logger = InMemoryLogger.getInstance();

        System.out.println("=== PC Builder Demo ===");

        boolean continueRunning = true;
        while (continueRunning) {
            try {
                System.out.print("Do you want a pre-built PC? (yes/no): ");
                String choice = scanner.nextLine();

                if (choice.equalsIgnoreCase("yes")) {
                    System.out.print("Type 'gaming' or 'office': ");
                    String type = scanner.nextLine();
                    if (type.equalsIgnoreCase("gaming")) {
                        director.constructGamingPC();
                    } else if (type.equalsIgnoreCase("office")) {
                        director.constructOfficePC();
                    } else {
                        System.out.println("Invalid choice. Proceeding with custom build.");
                    }
                }

                // Custom build input
                if (builder.getMotherboard() == null) {
                    System.out.print("Enter Motherboard: ");
                    builder.setMotherboard(scanner.nextLine());
                }
                if (builder.getCpu() == null) {
                    System.out.print("Enter CPU: ");
                    builder.setCpu(scanner.nextLine());
                }
                if (builder.getRam() == null) {
                    System.out.print("Enter RAM: ");
                    builder.setRam(scanner.nextLine());
                }
                if (builder.getStorage() == null) {
                    System.out.print("Enter Storage: ");
                    builder.setStorage(scanner.nextLine());
                }
                if (builder.getPowerSupply() == null) {
                    System.out.print("Enter Power Supply: ");
                    builder.setPowerSupply(scanner.nextLine());
                }

                // Optional components
                boolean addMore = true;
                while (addMore) {
                    System.out.print("Add optional component (GPU/Extra Storage/Case) or 'done' to finish: ");
                    String opt = scanner.nextLine();
                    if (opt.equalsIgnoreCase("done")) {
                        addMore = false;
                    } else {
                        builder.addOptionalComponent(opt);
                    }
                }

                // Build PC
                PC pc = builder.build();
                System.out.println("\n✅ PC successfully built!");
                System.out.println(pc);

                // Print in-memory logs
                logger.printLogs();
                logger.clear(); // clear logs for next iteration

                System.out.print("\nBuild another PC? (yes/no): ");
                String again = scanner.nextLine();
                if (!again.equalsIgnoreCase("yes")) {
                    continueRunning = false;
                }

            } catch (Exception e) {
                logger.error("Exception occurred: " + e.getMessage());
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Exiting PC Builder. Goodbye!");
        scanner.close();
    }
}
