package com.example.ebook;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InMemoryLogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final List<String> logs = new ArrayList<>();

    public static void info(String message) {
        String log = "[INFO] " + LocalDateTime.now().format(formatter) + " - " + message;
        logs.add(log);
        System.out.println(log); // optional: still print to console
    }

    public static void warn(String message) {
        String log = "[WARN] " + LocalDateTime.now().format(formatter) + " - " + message;
        logs.add(log);
        System.out.println(log);
    }

    public static void error(String message) {
        String log = "[ERROR] " + LocalDateTime.now().format(formatter) + " - " + message;
        logs.add(log);
        System.err.println(log);
    }

    public static List<String> getLogs() {
        return new ArrayList<>(logs); // return a copy to prevent modification
    }

    public static void clearLogs() {
        logs.clear();
    }
}
