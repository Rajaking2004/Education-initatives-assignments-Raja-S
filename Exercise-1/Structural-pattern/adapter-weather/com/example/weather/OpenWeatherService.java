package com.example.weather;

public class OpenWeatherService implements IWeatherService {

    @Override
    public double getTemperatureInCelsius(String city) {
        // Simulate fetching temperature from old API
        System.out.println("Fetching temperature from OpenWeatherService for " + city);
        return 25.0; // dummy temperature in Celsius
    }
}
