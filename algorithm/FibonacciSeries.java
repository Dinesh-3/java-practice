package algorithm;

public class FibonacciSeries {
    public int[] get(int number) {
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
}
