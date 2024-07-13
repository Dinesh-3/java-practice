package model;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop o1 = (Laptop) o;
        return price == o1.price && RAM == o1.RAM && ROM == o1.ROM && Objects.equals(name, o1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, RAM, ROM);
    }
}
