package pattern;

public abstract class AbstractProfession implements Cloneable{
    abstract String profession();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
