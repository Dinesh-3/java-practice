package searching;

public class BinarySearch {
    public static int index(int[] array, int item) {
        if(array.length == 1 && array[0] == item) return 1;
        return -1;
    }
}
