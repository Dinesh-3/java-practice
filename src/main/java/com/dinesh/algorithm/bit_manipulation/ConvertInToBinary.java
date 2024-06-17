package com.dinesh.algorithm.bit_manipulation;

public class ConvertInToBinary {

    public static void main(String[] args) {
        ConvertInToBinary binary = new ConvertInToBinary();
        String result = binary.convertToBinary(8);
        System.out.println("result = " + result);

        int toInt = binary.convertBinaryToInt("1011");
        System.out.println("toInt = " + toInt);

    }

    private String convertToBinary(int number) {

        var builder = new StringBuilder();

        while (number > 0) {
            if(number % 2 == 1)
                builder.insert(0, '1');
            else
                builder.insert(0, '0');
            number = number / 2;
        }

        return builder.toString();

    }

    private int convertBinaryToInt(String bin) {

        char[] array = bin.toCharArray();

        int sum = 0;
        int pow = 1;

        for (int i = array.length - 1; i >= 0; i--) {
            char ch = array[i];
            if(ch == '1')
                sum += pow;
            pow = pow * 2;

        }

        return sum;

    }

}
