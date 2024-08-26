package com.dinesh.algorithm.graph.shortest_path;

/**
 *
 * 1334. Find the City With the Smallest Number of Neighbors at a Threshold Distance
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance
 *
 */
public class FindCityWithSmallestNumberOfNeighborsWithGivenThreshold {

    public static void main(String[] args) {
        var path = new FindCityWithSmallestNumberOfNeighborsWithGivenThreshold();
        int n = 5;
        int[][] edges = {{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}};
        int distanceThreshold = 2;
        path.findTheCity(n, edges, distanceThreshold);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = (int) 1e9;
            }
        }

        for(int[] edge: edges) {
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }

        for(int via = 0; via < n; via++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][via] + matrix[via][j]);
                }
            }
        }

        int node = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] <= distanceThreshold)
                    count++;
            }
            if(count != 0 && count <= min) {
                node = i;
                min = count;
            }
        }

        return node;
    }
}
