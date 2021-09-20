package algorithm;

import java.util.Arrays;

public class ListProblem {
    public static void main(String[] args) {
        shuffleArrayItemsInRandomOrder();
    }

    private static void shuffleArrayItemsInRandomOrder() {
        /**
         * Operation O(N)
         */
        int[] numbers = {1,4,5,3,7,2};
        for (int i = numbers.length -1 ; i >= 0; i--) {
            double random = Math.random() * i;
            int alterIndex = (int) Math.floor(random);
//            System.out.println("random = " + random);
//            System.out.println("alterIndex = " + alterIndex);
            swap(numbers, alterIndex, i);
        }

        System.out.println("numbers = " + Arrays.toString(numbers));
    }

    private static void swap(int[] numbers, int alterIndex, int index) {
        int temp = numbers[alterIndex];
        numbers[alterIndex] = numbers[index];
        numbers[index] = temp;
    }

    private static void firstMissingPositive() {
        /**
         *
         */
        int[] numbers = {4,5,1,3,7};
        int positive = 1;
//        for (int i = 0; i < numbers.length; i++) {
//            if(numbers[i] )
//        }
    }
}
