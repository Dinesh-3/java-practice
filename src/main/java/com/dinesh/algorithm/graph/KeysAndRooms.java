package com.dinesh.algorithm.graph;

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args) {

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> keys = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while(!stack.isEmpty()) {
            Integer pop = stack.pop();
            keys.add(pop);

            for (Integer i : rooms.get(pop)) {
                if(!keys.contains(i))
                    stack.push(i);
            }
        }

        return keys.size() == rooms.size();

    }
}
