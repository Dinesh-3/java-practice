package com.dinesh.algorithm.bit_manipulation;

import com.dinesh.design_patterns.behavioural.state1.SelectionTool;

public class CheckIthBitIsSetOrNot {
    public static void main(String[] args) {
        int number = 13;
        int ith = 1;

        // 1101
        //Using Left shift
        if((number & (1 << ith)) != 0)
            System.out.println("Set ");
        else
            System.out.println("Not Set");

        // Using Right Shift
        if(( number >> ith & 1) == 1)
            System.out.println("Set ");
        else
            System.out.println("Not Set");

    }
}
