package model;

import java.time.LocalDateTime;

public class Laptop {
    private final String[] PROCESSORS = { "AMD", "INTEL" };
    private String name;
    private int price;
    private byte RAM;
    private int ROM;
    private LocalDateTime dateOfSale;

    public Laptop(String name, int price, byte RAM, int ROM, LocalDateTime dateOfSale) {
        this.name = name;
        this.price = price;
        this.RAM = RAM;
        this.ROM = ROM;
        this.dateOfSale = dateOfSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public byte getRAM() {
        return RAM;
    }

    public void setRAM(byte RAM) {
        this.RAM = RAM;
    }

    public int getROM() {
        return ROM;
    }

    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    public LocalDateTime getDateOfSale() {
        return dateOfSale;
    }

    private void setDateOfSale(LocalDateTime dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

}
