package com.dinesh.algorithm.array;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        int[] numbers = { 1,2 };
        List<List<Integer>> subsets = getSubsets(numbers);
        System.out.println("subsets = " + subsets);
    }

    public static List<List<Integer>> getSubsets(int[] numbers) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        setAllSubSets(numbers, subsets, current);
        return subsets;
    }

    private static void setAllSubSets(int[] numbers, List<List<Integer>> subsets, List<Integer> current) {

    }

}
