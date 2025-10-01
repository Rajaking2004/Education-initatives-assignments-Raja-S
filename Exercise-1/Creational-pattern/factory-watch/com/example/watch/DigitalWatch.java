package com.example.watch;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DigitalWatch implements Watch {
    @Override
    public void showTime() {
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println("⌚ Digital Watch - Time: " + time);
    }
}
