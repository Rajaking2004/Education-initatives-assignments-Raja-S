package com.example.weather;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WeatherApp {
    public static void main(String[] args) {
        WeatherApp app = new WeatherApp();
        app.start();
    }

    private void start() {
        Scanner scanner = new Scanner(System.in);
        InMemoryLogger.info("Weather App started.");

        IWeatherService oldService = new OpenWeatherService();
        NewWeatherApi api = new NewWeatherApi(); // keep reference to show cities
        IWeatherService newService = new NewWeatherAdapter(api);

        boolean exitRequested = false; 
        do {
            try {
                exitRequested = showMenu(scanner, oldService, newService, api);
            } 
            catch (InputMismatchException ime) {
                InMemoryLogger.error("Invalid input type. Please try again.");
                scanner.nextLine(); // clear buffer
            } 
            catch (Exception e) {
                InMemoryLogger.error("Unexpected error: " + e.getMessage());
            }
        } while (!exitRequested);

        InMemoryLogger.info("Weather App terminated.");

        // Print all logs at the end
        System.out.println("\n=== In-Memory Log History ===");
        for (String log : InMemoryLogger.getLogs()) {
            System.out.println(log);
        }

        scanner.close();
    }

    private boolean showMenu(Scanner scanner, IWeatherService oldService, IWeatherService newService, NewWeatherApi api) {
        System.out.println("\n=== Weather App Menu ===");
        System.out.println("1) Get temperature from OpenWeatherService");
        System.out.println("2) Get temperature from NewWeatherApi (Adapter)");
        System.out.println("3) Exit");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                getTemperature(scanner, oldService, null);
                return false;
            case "2":
                System.out.println("Supported cities in NewWeatherApi: " + api.getSupportedCities());
                getTemperature(scanner, newService, api);
                return false;
            case "3":
                InMemoryLogger.info("Exit requested by user.");
                return true;
            default:
                InMemoryLogger.warn("Invalid menu choice: " + choice);
                return false;
        }
    }

    private void getTemperature(Scanner scanner, IWeatherService service, NewWeatherApi api) {
        System.out.print("Enter city name: ");
        String city = scanner.nextLine().trim();

        if (city.isEmpty()) {
            InMemoryLogger.warn("City name cannot be empty.");
            System.out.println(" Please enter a valid city.");
            return;
        }

        try {
            double temp = service.getTemperatureInCelsius(city);
            System.out.printf("Temperature in %s: %.2f°C\n", city, temp);
            InMemoryLogger.info("Temperature fetched for city: " + city);
        } catch (Exception e) {
            InMemoryLogger.error("Failed to fetch temperature: " + e.getMessage());
            System.out.println(" Could not fetch temperature for " + city);
        }
    }
}
