package com.dinesh.algorithm.heap;

public class MaxHeap {
    private int[] array = new int[1000];
    private int size = 0;

    public void add(int number) {
        array[size++] = number;
        bubbleUp(number);
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        var root = array[0];
        array[0] = array[size--];

        bubbleDown();

        return root;
    }

    private void bubbleDown() {
        int index = 0;

        while (!isValidParent(index)) {
            int maxIndex = getMaxChildIndex(index);
            swap(array, 0, maxIndex);
            index = maxIndex;
        }
    }

    private boolean isValidParent(int index) {
        if (!hasLeftChild(index))
            return true;
        if (!hasRightChild(index))
            return array[index] >= leftChild(index);
        return array[index] >= leftChild(index) &&
                array[index] >= rightChild(index);
    }

    private int getMaxChildIndex(int index) {
        if (!hasLeftChild(index))
            return index;
        if (!hasRightChild(index))
            return leftChildIndex(index);
        return leftChild(index) > rightChild(index) ?
                leftChildIndex(index) : rightChildIndex(index);
    }

    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    private int leftChild(int index) {
        return array[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return array[rightChildIndex(index)];
    }

    private int leftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int rightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp(int number) {

        int index = size - 1;

        while (index > 0 && number > getParent(array, index)) {
            int parentIndex = getParentIndex(index);
            swap(array, index, parentIndex);
            index = parentIndex;
        }

    }

    private int getParent(int[] array, int index) {
        return array[getParentIndex(index)];
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void heapify(int[] list) {
        int lastParentIndex = (list.length / 2) - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
            heapify(list, i);
        }
    }

    private static void heapify(int[] array, int index) {

        int largerIndex = index;

        int leftChildIndex = (index * 2) + 1;
        if (leftChildIndex < array.length &&
                array[largerIndex] < array[leftChildIndex])
            largerIndex = leftChildIndex;

        int rightChildIndex = (index * 2) + 2;
        if (rightChildIndex < array.length &&
                array[largerIndex] < array[rightChildIndex]
        )
            largerIndex = rightChildIndex;

        if (index == largerIndex) // means it's in correct place
            return;

        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    public int getKthLargest(int[] array, int kth) {
        if(kth < 1 || kth > array.length)
            throw new IllegalArgumentException();

        MaxHeap heap = new MaxHeap();

        for (int i = 0; i < array.length; i++) {
            heap.add(array[i]);
        }

        for (int i = 0; i < kth - 1; i++) {
            heap.remove();
        }

        return heap.max();
    }

    public int max() {
        return array[0];
    }

    public static boolean isMaxHeap(int[] array) {

        for (int index = 0; index < array.length; index++) {

            int largerIndex = index;

            int leftChildIndex = (index * 2) + 1;
            if (leftChildIndex < array.length &&
                    array[largerIndex] < array[leftChildIndex])
                largerIndex = leftChildIndex;

            int rightChildIndex = (index * 2) + 2;
            if (rightChildIndex < array.length &&
                    array[largerIndex] < array[rightChildIndex]
            )
                largerIndex = rightChildIndex;

            if (index != largerIndex)
                return false;
        }
        return true;
    }

}
