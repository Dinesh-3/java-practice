package algorithm;

public class KadaneProblem {
    public static void main(String[] args) {
        /**
         * Find Max Sum from sub array
         */
        int[] numbers = {-2, 3, 2, -1};
        int maxCurrent = numbers[0];
        int maxGlobal = numbers[0];

        for (int i = 1; i < numbers.length; i++) {
            maxCurrent = Integer.max(numbers[i], maxCurrent + numbers[i]);
            if(maxCurrent > maxGlobal) maxCurrent = maxGlobal;
        }
        System.out.println("maxGlobal = " + maxGlobal);
    }
}
