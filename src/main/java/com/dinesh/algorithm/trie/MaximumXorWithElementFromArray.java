package com.dinesh.algorithm.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumXorWithElementFromArray {
    class Node {
        Node[] children = new Node[2];

        public boolean contains(int bit) {
            return children[bit] != null;
        }

        public Node get(int bit) {
            return children[bit];
        }

        public void set(int bit) {
            children[bit] = new Node();
        }
    }

    class Trie {
        private int maxBit = 31;
        private Node root = new Node();

        public void insert(int number) {
            Node current = root;

            for(int i = maxBit; i >= 0; i--) {
                int bit = (number >> i) & 1;
                if(!current.contains(bit))
                    current.set(bit);
                current = current.get(bit);
            }
        }

        public int getMax(int number) {
            Node current = root;
            int total = 0;

            for(int i = maxBit; i >= 0; i--) {
                int bit = (number >> i) & 1;
                if(current.contains(1-bit)) {
                    total = total | (1 << i);
                    current = current.get(1-bit);
                } else {
                    current = current.get(bit);
                }
            }

            return total;
        }

    }

    class Pair {
        int number;
        int limit;
        int index;
        public Pair(int number, int limit, int index) {
            this.number = number;
            this.limit = limit;
            this.index = index;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        List<Pair> pairs = IntStream.range(0, queries.length)
                .mapToObj(index -> new Pair(queries[index][0], queries[index][1], index))
                .sorted(Comparator.comparingInt(a -> a.limit))
                .collect(Collectors.toList());

        int[] result = new int[queries.length];

        Trie trie = new Trie();

        int numIndex = 0;

        for(Pair pair: pairs) {
            while (numIndex < nums.length && nums[numIndex] <= pair.limit)
                trie.insert(nums[numIndex++]);
            result[pair.index] = trie.getMax(pair.number);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4};
        int[][] queries = {{3,1},{1,3},{5,6}};


        MaximumXorWithElementFromArray xor = new MaximumXorWithElementFromArray();

        int[] result = xor.maximizeXor(nums, queries);
        System.out.println("result = " + Arrays.toString(result));

    }

}
