package design_patterns.creational.singleton;

//import java.io.Serial;
import java.io.Serializable;

public class SingletonClass implements Cloneable, Serializable {
    private volatile static SingletonClass singletonClass = null;

    private SingletonClass() {
        if(singletonClass != null) throw new IllegalStateException("Object already created");
    }

    public static SingletonClass getInstance() {
        if(singletonClass == null) setValue();
        return singletonClass;
    }

    private static synchronized void setValue() {
        if(singletonClass == null) singletonClass = new SingletonClass();
    }

    /**
     * For prevent from serialization
     * Instead of returning the deserialized object we return the singleton object
     * So readObject is return the singleton object
     */
//    @Serial // Java 16
    protected Object readResolve() {
        return getInstance();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
