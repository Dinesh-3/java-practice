package com.dinesh.algorithm.stack;


/**
 *
 *
 *
 */
public class NumberOfNGEsToTheRight {
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] result = new int[queries];

        for(int i = 0; i < queries; i++) {
            int index = indices[i];
            int count = 0;
            for(int j = index + 1; j < arr.length; j++)
                if(arr[j] > arr[index])
                    count++;
            result[i] = count;
        }

        return result;

    }

}
