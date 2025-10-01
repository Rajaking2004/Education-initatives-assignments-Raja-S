package com.example.payment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryLogger {
    private static final List<String> logs = new ArrayList<>();

    private InMemoryLogger() {}

    private static void log(String level, String message) {
        String logEntry = String.format("[%s] [%s] %s",
                LocalDateTime.now(), level, message);
        logs.add(logEntry);
    }

    public static void info(String message) {
        log("INFO", message);
    }

    public static void warn(String message) {
        log("WARN", message);
    }

    public static void error(String message) {
        log("ERROR", message);
    }

    public static List<String> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public static void printLogs() {
        logs.forEach(System.out::println);
    }

    public static void clear() {
        logs.clear();
    }
}
