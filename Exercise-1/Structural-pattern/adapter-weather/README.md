# 🌤️ Adapter Pattern – Weather Service Example

## 1. Project Overview
This project demonstrates the **Adapter Design Pattern** using a **Weather Service Integration** scenario.  

In the system:
- Your application uses an existing `IWeatherService` interface to get temperature data in **Celsius**.  
- A new third-party API (`NewWeatherApi`) provides temperature in **Kelvin** with a different method signature.  
- The **Adapter** (`NewWeatherAdapter`) bridges the new API to the existing interface, allowing seamless integration without changing client code.

---

## 2. Folder Structure
```
Structural-pattern/
adapter-weather/
├── com/example/weather/
│   ├── IWeatherService.java
│   ├── OpenWeatherService.java
│   ├── NewWeatherApi.java
│   ├── NewWeatherAdapter.java
│   ├── WeatherApp.java        (main class)
│   └── InMemoryLogger.java    
└── README.md


```

---

## 3. Compilation & Execution

### Step 1 – Navigate
```
cd Structural-pattern/adapter-weather
```
Step 2 – Compile
```

javac com/example/weather/*.java
```
Step 3 – Run
```
java com.example.weather.WeatherApp
```
4. Example Run
```
=== Weather App Menu ===
1) Get temperature from OpenWeatherService
2) Get temperature from NewWeatherApi (Adapter)
3) Exit
Enter choice: 2
Supported cities in NewWeatherApi: [New York, Chennai, Tokyo, London, Dubai, Paris]
Enter city name: Chennai
Fetching temperature from NewWeatherApi for Chennai
Temperature in Chennai: 30.00°C
[INFO] 2025-10-02 01:06:15 - Temperature fetched for city: Chennai

=== Weather App Menu ===
1) Get temperature from OpenWeatherService
2) Get temperature from NewWeatherApi (Adapter)
3) Exit
Enter choice: 3
[INFO] 2025-10-02 01:06:22 - Exit requested by user.
[INFO] 2025-10-02 01:06:22 - Weather App terminated.

=== In-Memory Log History ===
[INFO] 2025-10-02 01:05:50 - Weather App started.
[INFO] 2025-10-02 01:06:02 - Temperature fetched for city: chennai
[INFO] 2025-10-02 01:06:15 - Temperature fetched for city: Chennai
[INFO] 2025-10-02 01:06:22 - Exit requested by user.
[INFO] 2025-10-02 01:06:22 - Weather App terminated.
PS C:\Education Initatives\Exercise-1\adapter-weather> java com.example.weather.WeatherApp
[INFO] 2025-10-02 01:07:09 - Weather App started.

=== Weather App Menu ===
1) Get temperature from OpenWeatherService
2) Get temperature from NewWeatherApi (Adapter)
3) Exit
Enter choice: 1
Enter city name: madurai
Fetching temperature from OpenWeatherService for madurai
Temperature in madurai: 25.00°C
[INFO] 2025-10-02 01:07:16 - Temperature fetched for city: madurai

=== Weather App Menu ===
1) Get temperature from OpenWeatherService
2) Get temperature from NewWeatherApi (Adapter)
3) Exit
Enter choice: 2
Supported cities in NewWeatherApi: [New York, Chennai, Tokyo, London, Dubai, Paris]
Enter city name: Chennai
Fetching temperature from NewWeatherApi for Chennai
Temperature in Chennai: 30.00°C
[INFO] 2025-10-02 01:07:23 - Temperature fetched for city: Chennai

=== Weather App Menu ===
1) Get temperature from OpenWeatherService
2) Get temperature from NewWeatherApi (Adapter)
3) Exit
Enter choice: 3
[INFO] 2025-10-02 01:07:26 - Exit requested by user.
[INFO] 2025-10-02 01:07:26 - Weather App terminated.

=== In-Memory Log History ===
[INFO] 2025-10-02 01:07:09 - Weather App started.
[INFO] 2025-10-02 01:07:16 - Temperature fetched for city: madurai
[INFO] 2025-10-02 01:07:23 - Temperature fetched for city: Chennai
[INFO] 2025-10-02 01:07:26 - Exit requested by user.
[INFO] 2025-10-02 01:07:26 - Weather App terminated.
```
5. How Adapter Pattern is Applied
The Adapter Pattern is applied as follows:

IWeatherService → Target interface expected by the client.

OpenWeatherService → Existing service implementing IWeatherService.

NewWeatherApi → Third-party API with incompatible method (getTempInKelvin()).

NewWeatherAdapter → Implements IWeatherService and internally calls NewWeatherApi, converting Kelvin → Celsius.

WeatherApp → Client code uses IWeatherService without worrying about the underlying API.
UML-like Structure
```
IWeatherService (Target Interface)
       ↑
----------------------
OpenWeatherService   NewWeatherAdapter
                        ↑
                 NewWeatherApi (Adaptee)

WeatherApp (Client) --> Uses IWeatherService
```
6. Key Benefits
✅ Integrates Incompatible APIs → Adapter allows using new API without changing client code.

✅ Decouples Client from Adaptee → Client code only depends on IWeatherService.

✅ Reusable → Adapter can be reused for multiple clients.

✅ Flexible and Maintainable → New APIs can be integrated easily using adapters.

7. Conclusion
The Adapter Pattern enables the system to work with new weather APIs seamlessly, converting incompatible interfaces into a form the client expects.
It’s a real-world example of integrating external services without modifying existing code.