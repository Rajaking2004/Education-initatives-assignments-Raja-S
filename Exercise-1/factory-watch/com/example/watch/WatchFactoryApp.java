package com.example.watch;

import java.util.Scanner;

public class WatchFactoryApp {

    public static void main(String[] args) {
        WatchFactoryApp app = new WatchFactoryApp();
        app.start();
    }

    private void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exitRequested;
            do {
                exitRequested = showMenu(scanner);
            } while (!exitRequested);

            System.out.println("Exiting Watch Factory. Goodbye!");
        }
    }

    private boolean showMenu(Scanner scanner) {
        System.out.println("\n=== Watch Factory ===");
        System.out.println("Choose watch type: 1) Digital  2) Analog  3) Smart  4) Exit");
        String choice = scanner.nextLine().trim();

        if ("4".equals(choice)) {
            return true;
        }

        Watch watch;
        switch (choice) {
            case "1": watch = WatchFactory.createWatch("digital"); break;
            case "2": watch = WatchFactory.createWatch("analog"); break;
            case "3": watch = WatchFactory.createWatch("smart");  break;
            default:
                System.out.println("Invalid choice. Try again.");
                return false;
        }

        watch.showTime();
        return false;
    }
}
