package dataStructure;

import java.util.Arrays;

public class Stack {
    private int size = 2;
    private int[] list = new int[size];
    private int index = 0;

    public void push(int item) {
        System.out.println("size = " + size);
        System.out.println("index = " + index);
        if(size == index + 1) {
            size = size*2;
            int[] newList = new int[size];
            for (int i = 0; i < index; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
        list[index++] = item;
    }

    public int pop(){
        if(isEmpty()) return 0;
        --index;
        int item = list[index];
        list[index] = 0;
        return item;
    }

    public int peek(){
        if(isEmpty()) return 0;
        return list[index - 1];
    }

    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(list, 0, index);
        return Arrays.toString(content);
    }
}
