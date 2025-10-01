package com.example.weather;

public class NewWeatherApi {
    public double fetchTempKelvin(String location) {
        System.out.println("Fetching temperature from NewWeatherApi for " + location);
        return 298.15; // dummy temperature in Kelvin (~25°C)
    }
}
