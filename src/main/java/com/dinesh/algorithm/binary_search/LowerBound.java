package com.dinesh.algorithm.binary_search;

public class LowerBound {
    public static void main(String[] args) {
        int n = 42;
        int[] array = {71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112};
        int x = 68;

        int ans = lowerBound(args, array, x);
        System.out.println("ans = " + ans);

        findFloor(array, n, x);
    }

    private static int lowerBound(String[] args, int[] array, int x) {
        int left = 0;
        int right = args.length - 1;

        int ans = array[array.length - 1];
        while(left < right) {
            int mid = left + (right - left) / 2;

            if(array[mid] >= x) {
                ans = array[mid];
                right = left - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    static int findFloor(int arr[], int n, long x) {
        int low = 0;
        int high = n - 1;

        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] >= x)
            {
                high = mid - 1;
                ans = mid;
            }
            else
                low = mid + 1;
        }

        return ans;

    }

}
