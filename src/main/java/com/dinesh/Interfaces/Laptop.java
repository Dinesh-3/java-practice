package Interfaces;

public interface Laptop {
    int RAM = 8; // public static is unnecessary

    static int getRam(){
        return RAM;
    }

    default int getHash() {
        return this.hashCode();
    }
}
