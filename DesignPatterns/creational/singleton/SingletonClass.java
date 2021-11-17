package DesignPatterns.creational.singleton;

import java.io.Serial;
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

    @Serial
    protected Object readResolve() { // For prevent from serialization
        return singletonClass;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
