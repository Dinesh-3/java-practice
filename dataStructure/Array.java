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
        handleArraySizeFull();
        array[count++] = item;
    }

    public void insert(T item, int position) {
        if(position >= count) throw new IllegalArgumentException("Index Out of range");
        handleArraySizeFull();
        for (int i = count; i > position; i--) {
            array[i] = array[i-1];
        }
        array[position] = item;
        count++;
    }
    public T get(int index) {
        if(index < 0 || index > count) throw new IllegalArgumentException();
        return array[index];
    }
    public void removeAt(int index) {
        if (index >= count)
            throw new IllegalArgumentException();

        // index: 4
        // i: 5
        // 4 <- 5
        // 5 <- 6
        // 6 <- 7
        for (int i = index; i < count; i++)
            array[i] = array[i + 1];
        count--;
    }

    public int indexOf(T item) {
        for (int i = 0; i < count; i++)
            if (array[i] == item)
                return i;
        return -1;
    }

    private void handleArraySizeFull() {
        if (array.length == count) {
            T[] newArray = (T[]) new Object[count * 2];
            for (int i = 0; i < count; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
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
