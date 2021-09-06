package object;

public class Dog extends Animal{

    public Dog(String name) {
        super(name);
    }

    @Override
    public String MakeSound() {
        return "Lol...";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
