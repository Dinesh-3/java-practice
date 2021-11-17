package design_patterns.creational.prototype;

public abstract class AbstractProfession implements Cloneable{
    abstract String profession();

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
