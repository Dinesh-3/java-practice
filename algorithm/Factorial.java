package algorithm;

public class Factorial {
    public int get(int number) {
        if(number == 1) return 1;
        return number * get(number - 1);
    }
}
