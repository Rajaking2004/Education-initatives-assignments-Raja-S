package com.example.weather;

import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherApp app = new WeatherApp();
        app.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Weather App (Adapter Pattern Demo) ===");

        IWeatherService oldService = new OpenWeatherService();
        IWeatherService newService = new NewWeatherAdapter(new NewWeatherApi());

        boolean exitRequested;
        do {
            exitRequested = showMenu(scanner, oldService, newService);
        } while (!exitRequested);

        System.out.println("Goodbye!");
        scanner.close();
    }

    private boolean showMenu(Scanner scanner, IWeatherService oldService, IWeatherService newService) {
        System.out.println("\nMenu:");
        System.out.println("1) Get temperature from OpenWeatherService");
        System.out.println("2) Get temperature from NewWeatherApi (Adapter)");
        System.out.println("3) Exit");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                System.out.print("Enter city: ");
                String city1 = scanner.nextLine();
                double temp1 = oldService.getTemperatureInCelsius(city1);
                System.out.printf("Temperature in %s: %.2f°C\n", city1, temp1);
                return false;

            case "2":
                System.out.print("Enter city: ");
                String city2 = scanner.nextLine();
                double temp2 = newService.getTemperatureInCelsius(city2);
                System.out.printf("Temperature in %s: %.2f°C\n", city2, temp2);
                return false;

            case "3":
                return true;

            default:
                System.out.println("Invalid choice. Try again.");
                return false;
        }
    }
}
