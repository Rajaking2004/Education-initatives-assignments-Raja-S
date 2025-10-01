package com.example.pc;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLogger {
    private List<String> logs = new ArrayList<>();

    private static InMemoryLogger instance = new InMemoryLogger();
    private InMemoryLogger() {}

    public static InMemoryLogger getInstance() {
        return instance;
    }

    public void info(String message) {
        logs.add("[INFO] " + message);
    }

    public void error(String message) {
        logs.add("[ERROR] " + message);
    }

    public void warn(String message) {
        logs.add("[WARN] " + message);
    }

    public void printLogs() {
        System.out.println("\n=== Logs ===");
        for (String log : logs) {
            System.out.println(log);
        }
    }

    public void clear() {
        logs.clear();
    }

    public List<String> getLogs() {
        return new ArrayList<>(logs); // safe copy
    }
}
