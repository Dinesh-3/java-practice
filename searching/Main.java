package searching;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        int index = LinearSearch.index(numbers, 56);
        System.out.println("index = " + index);
    }
}
