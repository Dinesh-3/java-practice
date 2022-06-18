package searching;

public class BinarySearch {
    public static int search(int[] array, int target) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var middle = left + (right - left) / 2;

            if (array[middle] == target)
                return middle;

            if (target < array[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 6,7,8,9,12,23,34,56,67};

        int search = search(numbers, 12);

    }

}
