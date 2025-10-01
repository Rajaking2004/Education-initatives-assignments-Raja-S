package com.example.ecommerce;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InMemoryLogger {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final List<String> logs = new ArrayList<>();

    private static void log(String level, String message, boolean error) {
        String entry = "[" + level + "] " + LocalDateTime.now().format(formatter) + " - " + message;
        logs.add(entry);
        if (error) {
            System.err.println(entry);
        } else {
            System.out.println(entry);
        }
    }

    public static void info(String message) { log("INFO", message, false); }
    public static void warn(String message) { log("WARN", message, false); }
    public static void error(String message) { log("ERROR", message, true); }

    public static List<String> getLogs() { return new ArrayList<>(logs); }
    public static void clearLogs() { logs.clear(); }
}
