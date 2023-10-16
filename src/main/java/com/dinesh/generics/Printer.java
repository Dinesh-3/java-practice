package generics;

import java.io.Serializable;

/**
 *
 * Class and Interface both will be mentioned as extends in Bound
 * First Class then Interface is the order
 */
public class Printer<T extends Number & Serializable>{

    private T data;

    public Printer(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void print() {
        System.out.println(data);
    }
}
