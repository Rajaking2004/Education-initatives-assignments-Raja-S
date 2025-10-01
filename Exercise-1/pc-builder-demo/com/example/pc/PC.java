package com.example.pc;

import java.util.List;

public class PC {
    private String motherboard;
    private String cpu;
    private String ram;
    private String storage;
    private String powerSupply;
    private List<String> optionalComponents;

    // Constructor receives builder
    public PC(String motherboard, String cpu, String ram, String storage, String powerSupply, List<String> optionalComponents) {
        this.motherboard = motherboard;
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.powerSupply = powerSupply;
        this.optionalComponents = optionalComponents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PC Configuration:\n");
        sb.append("Motherboard: ").append(motherboard).append("\n");
        sb.append("CPU: ").append(cpu).append("\n");
        sb.append("RAM: ").append(ram).append("\n");
        sb.append("Storage: ").append(storage).append("\n");
        sb.append("Power Supply: ").append(powerSupply).append("\n");
        if (!optionalComponents.isEmpty()) {
            sb.append("Optional Components: ").append(String.join(", ", optionalComponents)).append("\n");
        } else {
            sb.append("Optional Components: None\n");
        }
        return sb.toString();
    }
}
