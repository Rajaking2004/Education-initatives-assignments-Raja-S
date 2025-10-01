package com.example.watch;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SmartWatch implements Watch {
    @Override
    public void showTime() {
        String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("⌚ Smart Watch - Full Date & Time: " + dateTime + " | Notifications: ON");
    }
}
