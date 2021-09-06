package dataStructure;

import java.util.Arrays;

public class Array<T> {

    private T[] array = (T[]) new Object[30];
    private int count;

    public Array() {
    }

    public Array(int size) {
        this.array = (T[]) new Object[size];
    }

    public void insert(T item) {
        if(array.length == count) {
            T[] newArray = (T[]) new Object[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[count++] = item;
    }

    public void print() {
        for (int i = 0; i < count; i++)
            System.out.print(array[i] + " ");
    }

    @Override
    public String toString() {
        return "[" + getItemsSeparateByComma() + "]";

    }

    private String getItemsSeparateByComma() {
        var items = "";
        for (int i = 0; i < count - 1; i++)
            items = items + array[i] + ", ";
        items += array[count - 1];
        return items;
    }
}
