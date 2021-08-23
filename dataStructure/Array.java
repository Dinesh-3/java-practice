package dataStructure;

import java.util.Arrays;

public class Array {

    private String[] array;
    private int size;
    private int count;
    public Array(int size) {
        this.size = size;
        this.array = new String[size];
    }

    public void insert(String item) {
        if(array.length == count) {
            String[] newArray = new String[count * 2];
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
        return Arrays.toString(array);
    }
}
