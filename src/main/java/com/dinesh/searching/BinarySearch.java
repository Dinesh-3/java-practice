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

        /**
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int midIndex = (left + right) / 2;
            if(array[midIndex] < target)
                right = midIndex;
            else if (array[midIndex] > target) {
                left = midIndex;
            }else {
                return midIndex;
            }
        }

        return -1;
        **/

    }

    public static int recursion(int[] array, int target) {
        return recursion(array, target, 0, array.length - 1);
    }

    public static int recursion(int[] array, int target, int left, int right) {
        if(left > right)
            return -1;
        int midIndex = left + (right - left) / 2;
        if(array[midIndex] == target)
            return midIndex;
        if(array[midIndex] < target)
            return recursion(array, target, left, midIndex);
        else
            return recursion(array, target, midIndex, right);
    }

    public static void main(String[] args) {

        int[] numbers = {2, 5, 6,7,8,9,12,23,34,56,67};

        int search = search(numbers, 12);

    }

}
