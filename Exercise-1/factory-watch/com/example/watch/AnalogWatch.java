package com.example.watch;

import java.time.LocalTime;

public class AnalogWatch implements Watch {
    @Override
    public void showTime() {
        LocalTime now = LocalTime.now();
        System.out.printf("⌚ Analog Watch - Hour hand at %d, Minute hand at %d%n",
                now.getHour() % 12, now.getMinute());
    }
}
