package com.dinesh.algorithm.binary_search;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station
 * https://www.youtube.com/watch?v=kMSBvlZ-_HA&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=23
 *
 *  Minimize Max Distance to Gas Station
 *  https://www.naukri.com/code360/problems/minimise-max-distance_7541449
 */
public class MinimizeMaxDistanceToGasStation {

    private static class Node {
        Double len;
        int placed;
        int index;

        public Node(Double len, int index) {
            this.len = len;
            this.index = index;
            placed = 1;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "len=" + len +
                    ", index=" + index +
                    '}';
        }
    }

    public static void main(String[] args) {
        int k = 1;
        int[] arr = { 1,2,3,4,5,6,7,8,9,10 };

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.len, Comparator.reverseOrder()));
        for (int i = 0; i < arr.length - 1; i++) {
            queue.add(new Node((double) (arr[i + 1] - arr[i]), i));
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println("queue = " + queue.poll());
        }

        System.out.println("queue = " + queue);

        MinimizeMaxDistanceToGasStation station = new MinimizeMaxDistanceToGasStation();
//        double result = station.MinimiseMaxDistanceBruteForce(arr, k);
//        System.out.println("result = " + result);

//        double distancePriorityQueue = station.MinimiseMaxDistancePriorityQueue(arr, k);
//        System.out.println("distancePriorityQueue = " + distancePriorityQueue);

        double distanceBinarySearch = station.minimiseMaxDistanceBinarySearch(arr, k);
        System.out.println("distanceBinarySearch = " + distanceBinarySearch);

    }



    public static double MinimiseMaxDistance(int []arr, int K){
        return 0;
    }

    public double MinimiseMaxDistanceBruteForce(int []arr, int K){
        int[] gaps = new int[arr.length - 1];

        for (int i = 0; i < K; i++) {
            double maxLength = -1;
            int maxIndex = -1;
            for (int j = 0; j < gaps.length; j++) {
                double length = arr[j + 1] - arr[j];
                double placementLength = length / (double) ( gaps[j] + 1 );
                if(maxLength < placementLength)
                {
                    maxLength = placementLength;
                    maxIndex = j;
                }
            }
            if(maxIndex >= 0)
                gaps[maxIndex] += 1;
        }

        double maxLength = -1;
        for (int j = 0; j < gaps.length; j++) {
            int length = arr[j + 1] - arr[j];
            if(gaps[j] <= 0)
                continue;
            double placementLength = length / (double) (gaps[j] + 1);
            maxLength = Math.max(maxLength, placementLength);
        }

        return maxLength;
    }

    public double MinimiseMaxDistancePriorityQueue(int []arr, int K){

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.len, Comparator.reverseOrder()));
        for (int i = 0; i < arr.length - 1; i++)
            queue.add(new Node((double) (arr[i + 1] - arr[i]), i));

        for (int j = 0; j < K; j++) {
            Node node = queue.poll();
            node.len = ( arr[node.index + 1] - arr[node.index] ) / (double) (node.placed + 1);
            node.placed += 1;
            queue.add(node);
        }

        return Objects.requireNonNull(queue.poll()).len;
    }


    public double minimiseMaxDistanceBinarySearch(int []arr, int K) {
        int maxDistance = 0;
        for (var num : arr)
            maxDistance = Math.max(maxDistance, num);

        double left = 0;
        double right = maxDistance;

        double diff = 0.000001; //1e-6;

        while ( right - left > diff ) {
            double middle = (left + right) / 2.0;
            int totalStations = totalNumberOfGasStations(arr, middle, K);
            if(totalStations > K)
                left = middle;
            else
                right = middle;
        }

        System.out.println("diff = " + diff);
        return right;
    }

    private int totalNumberOfGasStations(int[] arr, double distance, int k) {
        int cnt = 0;

        for(int i = 1; i < arr.length; i++){
            double numberInBtw = Math.ceil((arr[i] - arr[i-1]) / distance);
            cnt += (int) (numberInBtw - 1);
        }
        return cnt;
    }

}
