package DesignPatterns.creational.factory;

public class Doctor implements Profession {
    @Override
    public String profession() {
        return "doctor";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
