package DesignPatterns.creational.prototype;

public class Doctor extends AbstractProfession  {
    @Override
    public String profession() {
        return "doctor";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
