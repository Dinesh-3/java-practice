package Interfaces;

public class Main {
    public static void main(String[] args) {
        int ram = Laptop.getRam();
        System.out.println("ram = " + ram);

        HP hp = new HP(20_000);
        int size = hp.getHash();

        HP hp1 = new HP(20_000);
        int size1 = hp1.getHash();

        System.out.println("size = " + size);
        System.out.println("size1 = " + size1);
    }
}
