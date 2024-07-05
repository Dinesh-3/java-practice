package com.dinesh.algorithm.graph;

import java.util.*;

/**
 *
 * Alien Dictionary - Topological Sort: G-26
 * https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
 *
 */
public class AlienDictionary {
    public static void main(String[] args) {
        int N = 5;
        int K = 4;

        String[] dict = {"baa","abcd","abca","cab","cad"};

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < K; i++)
            list.add(new ArrayList<>());

        for (int i = 0; i < dict.length - 1; i++) {
            String first = dict[i];
            String second = dict[i+1];
            int minLength = Math.min(first.length(), second.length());
            for (int j = 0; j < minLength; j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    if(!list.get(first.charAt(j) - 'a').contains(second.charAt(j) - 'a'))
                    {
                        list.get(first.charAt(j) - 'a').add(second.charAt(j) - 'a');
                    }
                    break;
                }
            }
        }

        int[] distances = new int[K];

        for (var edges : list) {
            for (int node: edges) {
                distances[node]++;
            }
        }
        System.out.println("list = " + list);
        System.out.println("distances = " + Arrays.toString(distances));
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < distances.length; i++)
            if(distances[i] == 0)
                queue.add(i);

        List<Integer> topo = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer item = queue.remove();
            topo.add(item);
            for(var ad: list.get(item)) {
                distances[ad]--;
                if(distances[ad] == 0)
                    queue.add(ad);
            }
        }

        for (int ch: topo)
            System.out.println("ch = " + (char)('a' + ch) );

    }
}
