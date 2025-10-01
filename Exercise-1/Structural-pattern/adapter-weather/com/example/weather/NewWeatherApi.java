package com.example.weather;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NewWeatherApi {

    private Map<String, Double> cityTemperatureMap;

    public NewWeatherApi() {
        cityTemperatureMap = new HashMap<>();

        // Hardcoded cities with approximate temperatures in Kelvin
        cityTemperatureMap.put("New York", 293.15);   // ~20°C
        cityTemperatureMap.put("London", 289.15);     // ~16°C
        cityTemperatureMap.put("Paris", 291.15);      // ~18°C
        cityTemperatureMap.put("Tokyo", 296.15);      // ~23°C
        cityTemperatureMap.put("Chennai", 303.15);    // ~30°C
        cityTemperatureMap.put("Dubai", 310.15);      // ~37°C
    }

    public double fetchTempKelvin(String location) {
        if (cityTemperatureMap.containsKey(location)) {
            System.out.println("Fetching temperature from NewWeatherApi for " + location);
            return cityTemperatureMap.get(location);
        } else {
            System.out.println("City not found, returning default temperature.");
            return 298.15; // ~25°C default
        }
    }

     public Set<String> getSupportedCities() {
        return cityTemperatureMap.keySet();
    }
}
