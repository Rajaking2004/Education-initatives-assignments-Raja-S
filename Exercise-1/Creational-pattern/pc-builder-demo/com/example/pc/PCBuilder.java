package com.example.pc;

import java.util.ArrayList;
import java.util.List;

public class PCBuilder implements Builder<PC> {
    private String motherboard;
    private String cpu;
    private String ram;
    private String storage;
    private String powerSupply;
    private List<String> optionalComponents = new ArrayList<>();
    private InMemoryLogger logger = InMemoryLogger.getInstance();

    public PCBuilder setMotherboard(String motherboard) {
        if (motherboard == null || motherboard.isBlank()) {
            logger.error("Attempted to set empty Motherboard");
            throw new IllegalArgumentException("Motherboard cannot be empty");
        }
        this.motherboard = motherboard;
        logger.info("Motherboard set to " + motherboard);
        return this;
    }

    public PCBuilder setCpu(String cpu) {
        if (cpu == null || cpu.isBlank()) {
            logger.error("Attempted to set empty CPU");
            throw new IllegalArgumentException("CPU cannot be empty");
        }
        this.cpu = cpu;
        logger.info("CPU set to " + cpu);
        return this;
    }

    public PCBuilder setRam(String ram) {
        if (ram == null || ram.isBlank()) {
            logger.error("Attempted to set empty RAM");
            throw new IllegalArgumentException("RAM cannot be empty");
        }
        this.ram = ram;
        logger.info("RAM set to " + ram);
        return this;
    }

    public PCBuilder setStorage(String storage) {
        if (storage == null || storage.isBlank()) {
            logger.error("Attempted to set empty Storage");
            throw new IllegalArgumentException("Storage cannot be empty");
        }
        this.storage = storage;
        logger.info("Storage set to " + storage);
        return this;
    }

    public PCBuilder setPowerSupply(String powerSupply) {
        if (powerSupply == null || powerSupply.isBlank()) {
            logger.error("Attempted to set empty Power Supply");
            throw new IllegalArgumentException("Power Supply cannot be empty");
        }
        this.powerSupply = powerSupply;
        logger.info("Power Supply set to " + powerSupply);
        return this;
    }

    public PCBuilder addOptionalComponent(String component) {
        if (component != null && !component.isBlank()) {
            optionalComponents.add(component);
            logger.info("Added optional component: " + component);
        } else {
            logger.warn("Ignored invalid optional component");
        }
        return this;
    }

    @Override
    public PC build() {
        if (motherboard == null || cpu == null || ram == null || storage == null || powerSupply == null) {
            logger.error("Cannot build PC, required components missing!");
            throw new IllegalStateException("All required components must be set!");
        }
        logger.info("PC successfully built!");
        return new PC(motherboard, cpu, ram, storage, powerSupply, optionalComponents);
    }

    // Getters for Director use
    public String getMotherboard() { return motherboard; }
    public String getCpu() { return cpu; }
    public String getRam() { return ram; }
    public String getStorage() { return storage; }
    public String getPowerSupply() { return powerSupply; }
    public List<String> getOptionalComponents() { return optionalComponents; }
}
