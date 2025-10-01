package com.example.weather;

public class NewWeatherAdapter implements IWeatherService {
    private NewWeatherApi newWeatherApi;

    public NewWeatherAdapter(NewWeatherApi newWeatherApi) {
        this.newWeatherApi = newWeatherApi;
    }

    @Override
    public double getTemperatureInCelsius(String city) {
        double tempKelvin = newWeatherApi.fetchTempKelvin(city);
        // Convert Kelvin to Celsius
        return tempKelvin - 273.15;
    }
}
