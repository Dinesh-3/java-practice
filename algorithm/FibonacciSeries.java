package algorithm;

public class FibonacciSeries {
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

    public int topDownApproach(int number) {
        int[] memoizeArray = new int[number+1];
        return topDownApproach(number,memoizeArray);
    }

    public int topDownApproach(int number, int[] memoizeArray) {
        // Top Down Approach
        int result;
        if(memoizeArray[number] != 0){
            return memoizeArray[number];
        }
        if(number == 1 || number == 2) {
            result = 1;
        }else {
            result = topDownApproach(number-1, memoizeArray) + topDownApproach(number-2, memoizeArray);
        }
        memoizeArray[number] = result;
        return result;
    }
}
