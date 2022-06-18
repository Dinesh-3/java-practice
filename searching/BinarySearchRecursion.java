package searching;

public class BinarySearchRecursion {
    public int binarySearchRec(int[] array, int target) {
        return binarySearchRec(array, target, 0, array.length - 1);
    }

//    private int binarySearchRec(int[] array, int target, int left, int right) {
//
//        if (right < left) return -1;
//
//        int middle = (left + right) / 2;
//
//        if (array[middle] == target) return middle;
//
//        if (target < array[middle]) return binarySearchRec(array, target, left, middle - 1);
//
//        return binarySearchRec(array, target, middle + 1, right);
//    }

    private int binarySearchRec(int[] array, int target, int left, int right){

        if(left > right) return 0;

        int middle = left + (right - left) / 2;

        if(array[middle] == target)
            return target;
        if(array[middle] < target)
            return binarySearchRec(array, target, middle, right);

        return binarySearchRec(array, target, left, middle);
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 6,7,8,9,12,23,34,56,67};
        BinarySearchRecursion search = new BinarySearchRecursion();
        int result = search.binarySearchRec(numbers, 12);
        System.out.println("result = " + result);
    }
}
