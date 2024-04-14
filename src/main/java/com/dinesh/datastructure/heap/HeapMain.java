package com.dinesh.datastructure.heap;

import java.util.Arrays;

public class HeapMain {
    public static void main(String[] args) {
        String str1 = "ABCABC";
        System.out.println("str1.substring(0, 6) = " + str1.substring(0, 6));

        Heap heap = new Heap();
        heap.add(10);
        heap.add(15);
        heap.add(20);
        heap.add(4);
        heap.add(5);

        heap.remove();

        int[] numbers = {5,3,8,4,1,2};

        Heap.heapify(numbers);

        System.out.println(Arrays.toString(numbers));
        System.out.println("Heap.isMaxHeap(numbers) = " + Heap.isMaxHeap(numbers));
    }

}
