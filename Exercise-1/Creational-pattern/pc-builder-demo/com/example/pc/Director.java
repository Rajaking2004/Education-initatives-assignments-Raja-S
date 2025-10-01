package com.example.pc;

public class Director {
    private PCBuilder builder;

    public Director(PCBuilder builder) {
        this.builder = builder;
    }

    public void constructGamingPC() {
        builder.setMotherboard("Z790 Gaming")
               .setCpu("Intel i9")
               .setRam("32GB DDR5")
               .setStorage("2TB NVMe SSD")
               .setPowerSupply("850W")
               .addOptionalComponent("RGB Lighting")
               .addOptionalComponent("Liquid Cooling");
    }

    public void constructOfficePC() {
        builder.setMotherboard("B660 Office")
               .setCpu("Intel i5")
               .setRam("16GB DDR4")
               .setStorage("1TB SSD")
               .setPowerSupply("650W");
    }
}
