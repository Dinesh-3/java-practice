package object;

public class Cat extends Animal{

//    @Override // Throws error field can't be override
//    protected  String name; // value is null because no constructor and setter
    // If we comment the above code super class field name accessed

    public Cat(String name) {
        super(name);
    }

    @Override
    public Object MakeSound() {
        return 1;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Cat{name=" + super.getName() + "}";
    }
}
