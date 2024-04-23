package com.dinesh.algorithm.leetcode75;
import java.util.*;

/**
 * 933. Number of Recent Calls
 *
 */
public class NumberOfRecentCalls {

    private final Queue<Integer> requests;
    public NumberOfRecentCalls() {
        this.requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.add(t);
        while (requests.peek() < t - 3000) {
            requests.poll();
        }
        return requests.size();
    }
}
