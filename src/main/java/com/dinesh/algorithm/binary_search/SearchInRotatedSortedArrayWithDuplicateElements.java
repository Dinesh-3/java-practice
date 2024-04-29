package com.dinesh.algorithm.binary_search;

public class SearchInRotatedSortedArrayWithDuplicateElements {
    public static void main(String[] args) {
        int[] arr = { 7,1,2,4,4,4,5,6,6,7 }; // duplicate values

        int target = 0;

        int leftIndex = 0;
        int rightIndex = arr.length - 1;

        while(leftIndex <= rightIndex) {

            int mid = leftIndex + ( rightIndex - leftIndex ) / 2;

            if(arr[mid] == target) {
                System.out.println("mid = " + mid);
                break;
            }

            if(arr[leftIndex] == arr[mid] && arr[mid] == arr[rightIndex])
            {
                leftIndex = leftIndex + 1;
                rightIndex = rightIndex - 1;
                continue;
            }

            if(arr[leftIndex] <= arr[mid]) {
                if(arr[leftIndex] <= target && arr[mid] >= target)
                    rightIndex = mid - 1;
                else
                    leftIndex = mid + 1;
            } else {
                if(arr[mid] <= target && arr[rightIndex] >= target)
                    leftIndex = mid + 1;
                else
                    rightIndex = mid - 1;
            }
        }

    }
}
