package algorithm;

import java.util.Arrays;

public class FibonacciSeries {
    public static void main(String[] args) {
//        1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987
        int number = 10;
        System.out.println("number = " + number);
        int topDownApproach = topDownApproach(number);
        System.out.println("recursion topDownApproach = " + topDownApproach);

        int lastValue = getLastValue(number);
        System.out.println("two integer = " + lastValue);

        int[] usingArray = usingArray(number);
        System.out.println("usingArray = " + Arrays.toString(usingArray));
    }
    public int[] get(int number) {
        // Bottom Up Approach
        int[] series = new int[number];
        int first = 0;
        int second = 1;

        series[0] = first;
        series[1] = second;

        int index = 2;
        while (index < number) {
            int nth = first + second;
            first = second;
            second = nth;
            series[index++] = nth;
        }
        return series;
    }

    public static int getLastValue(int number){
        int first = 1;
        int second = 1;
        for (int i = 1; i < number ; i++) {
            int temp = second;
            second += first;
            first = temp;
        }
        return second;
    }

    public static int[] usingArray(int number) {
        int[] fib = new int[number+1];
        fib[0] = 1;
        fib[1] = 1;
        for (int i = 2; i <= number; i++) {
            fib[i] = fib[i-1] + fib[i-2];
//            fib[i+1] += fib[i]; // SAME
//            fib[i+2] += fib[i];
        }
        return fib;
    }

    public static int topDownApproach(int number) {
        int[] memoizeArray = new int[number+1];
        return topDownApproach(number,memoizeArray);
    }

    public static int topDownApproach(int number, int[] memoizeArray) {
        // Top-Down Approach
        int result;
        if(memoizeArray[number] != 0){
            return memoizeArray[number];
        }
        if(number <= 1) { // number == 0 || number == 1
            result = 1;
        }else {
            result = topDownApproach(number-1, memoizeArray) + topDownApproach(number-2, memoizeArray);
        }
        memoizeArray[number] = result;
        return result;
    }
}
