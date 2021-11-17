package design_patterns.creational.factory;

public class Teacher implements Profession {
    @Override
    public String profession() {
        return "teacher";
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
