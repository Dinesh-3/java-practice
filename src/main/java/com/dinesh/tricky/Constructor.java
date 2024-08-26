package com.dinesh.tricky;

public class Constructor {
    public Constructor(){
        this(1);
        System.out.println("Level 1 ");
    }

    public Constructor(int i) {
        this(1,i);
//        this(); // Recursive constructor invocation
        System.out.println("Level 2 ");
    }


    public Constructor(int i, int j) {
        System.out.println("Level 3 ");
    }

    public static void main(String[] args) {
        Constructor constructor = new Constructor();
    }
}
