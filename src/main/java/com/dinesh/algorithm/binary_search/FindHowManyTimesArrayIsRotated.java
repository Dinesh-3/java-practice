package com.dinesh.algorithm.binary_search;

/**
 *
 * Find out how many times the array has been rotated
 * https://www.youtube.com/watch?v=jtSiWTPLwd0
 *
 * Similar TO ->  Find minimum in Rotated Sorted Array,
 */
public class FindHowManyTimesArrayIsRotated {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        int minimumIndex = 0;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + ( rightIndex - leftIndex ) / 2;

            if(arr[leftIndex] <= arr[rightIndex]) {
                if(arr[leftIndex] < arr[minimumIndex]) {
                    minimumIndex = leftIndex;
                }
                break;
            }

            if(arr[leftIndex] <= arr[middleIndex]) {
                if(arr[middleIndex] < arr[minimumIndex])
                    minimumIndex = middleIndex;
                leftIndex = middleIndex + 1;
            } else {
                if(arr[middleIndex] < arr[minimumIndex])
                    minimumIndex = leftIndex;
                rightIndex = middleIndex - 1;
            }
        }

        System.out.println("minimumIndex = " + minimumIndex);

    }

    int findKRotationOptimal(int arr[], int n) {
        int low = 0;
        int high = arr.length - 1;

        if(arr[low] <= arr[arr.length - 1])
            return 0;

        while( low <= high ) {
            int mid = (low + high) / 2;
            if(arr[mid] >= arr[0])
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

}
