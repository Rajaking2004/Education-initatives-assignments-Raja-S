package com.example.watch;

public class WatchFactory {
    public static Watch createWatch(String type) {
        switch (type.toLowerCase()) {
            case "digital": return new DigitalWatch();
            case "analog": return new AnalogWatch();
            case "smart":  return new SmartWatch();
            default: throw new IllegalArgumentException("Unknown watch type: " + type);
        }
    }
}
