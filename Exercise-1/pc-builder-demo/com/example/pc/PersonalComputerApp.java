package com.example.pc;

import java.util.Scanner;

public class PersonalComputerApp {

    public static void main(String[] args) {
        new PersonalComputerApp().start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            PCBuilder builder = new PCBuilder();
            Director director = new Director(builder);
            InMemoryLogger logger = InMemoryLogger.getInstance();

            System.out.println("=== PC Builder Demo ===");

            boolean exitRequested;
            do {
                try {
                    System.out.print("Do you want a pre-built PC? (yes/no): ");
                    String choice = scanner.nextLine().trim();

                    if ("yes".equalsIgnoreCase(choice)) {
                        System.out.print("Type 'gaming' or 'office': ");
                        String type = scanner.nextLine().trim();
                        if ("gaming".equalsIgnoreCase(type)) {
                            director.constructGamingPC();
                            logger.info("Pre-built Gaming PC selected.");
                        } else if ("office".equalsIgnoreCase(type)) {
                            director.constructOfficePC();
                            logger.info("Pre-built Office PC selected.");
                        } else {
                            logger.warn("Invalid pre-built PC choice: " + type);
                            System.out.println("Invalid choice. Proceeding with custom build.");
                        }
                    }

                    // Custom build input (only if not set by Director)
                    if (builder.getMotherboard() == null) {
                        System.out.print("Enter Motherboard: ");
                        builder.setMotherboard(scanner.nextLine().trim());
                    }
                    if (builder.getCpu() == null) {
                        System.out.print("Enter CPU: ");
                        builder.setCpu(scanner.nextLine().trim());
                    }
                    if (builder.getRam() == null) {
                        System.out.print("Enter RAM: ");
                        builder.setRam(scanner.nextLine().trim());
                    }
                    if (builder.getStorage() == null) {
                        System.out.print("Enter Storage: ");
                        builder.setStorage(scanner.nextLine().trim());
                    }
                    if (builder.getPowerSupply() == null) {
                        System.out.print("Enter Power Supply: ");
                        builder.setPowerSupply(scanner.nextLine().trim());
                    }

                    // Optional components loop
                    String opt;
                    do {
                        System.out.print("Add optional component (GPU/Extra Storage/Case) or 'done' to finish: ");
                        opt = scanner.nextLine().trim();
                        if (!"done".equalsIgnoreCase(opt) && !opt.isEmpty()) {
                            builder.addOptionalComponent(opt);
                            logger.info("Added optional component: " + opt);
                        }
                    } while (!"done".equalsIgnoreCase(opt));

                    // Build PC
                    PC pc = builder.build();
                    System.out.println("\n PC successfully built!");
                    System.out.println(pc);
                    logger.info("PC successfully built: " + pc);

                    // Show logs
                    System.out.println("\n=== Log History ===");
                    logger.printLogs();
                    logger.clear();

                } catch (Exception e) {
                    logger.error("Exception occurred: " + e.getMessage());
                    System.out.println("Error: " + e.getMessage());
                }

                // Ask if user wants to build another PC
                System.out.print("\nBuild another PC? (yes/no): ");
                String again = scanner.nextLine().trim();
                exitRequested = !"yes".equalsIgnoreCase(again);

            } while (!exitRequested);

            System.out.println("Exiting PC Builder. Goodbye!");
        }
    }
}
