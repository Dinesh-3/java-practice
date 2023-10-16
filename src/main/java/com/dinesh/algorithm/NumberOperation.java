package algorithm;

public class NumberOperation {
    public static void main(String[] args) {
        String binary = convertToBinary(6);
        System.out.println("binary = " + binary);
    }

    private static String convertToBinary(int value){

        StringBuilder binaryBuilder = new StringBuilder();

        while (value > 0){
            int bin = value % 2;
            binaryBuilder.append(bin);
            value = value / 2;
        }

        return binaryBuilder.reverse().toString();


    }
}
