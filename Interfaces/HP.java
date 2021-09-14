package Interfaces;

public class HP implements Laptop{
    private int price;

    public HP(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
