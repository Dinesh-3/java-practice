package algorithm;

public class Factorial {
    public static void main(String[] args) {
        int number = 30;
        long fact = fact(number);
        long get = get(number);
        System.out.println("fact = " + fact);
        System.out.println("get = " + get);
    }
    public static long get(int number) {
        if(number <= 1) return 1;
        return number * get(number - 1);
    }

    public static long fact(int number){
        long result = 1;
        for (int i = number; i > 0; i--) {
            result *= i;
        }
        return result;
    }

}
