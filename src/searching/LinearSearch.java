package searching;

public class LinearSearch {
    public static int index(int[] array, int item) {
        for (int i = 0; i < array.length; i++)
            if(array[i] == item) return i;

        return -1;
    }
}
