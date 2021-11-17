package DesignPatterns.creational.prototype;

public class Teacher extends AbstractProfession {
    @Override
    public String profession() {
        return "teacher";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
