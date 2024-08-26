package com.dinesh.algorithm.doubly_linkedlist;

import java.util.*;

/**
 *
 * Find pairs with given sum in doubly linked list
 * https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list
 */
public class FindPairsWithGivenSum {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        Set<Integer> visited = new HashSet<>();


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        Node current = head;

        while(current != null) {
            if(current.data > target)
                break;
            if(visited.contains(target - current.data))
                result.add(new ArrayList<>(List.of(target - current.data, current.data)));
            visited.add(current.data);
            current = current.next;
        }

        result.sort(Comparator.comparingInt(a -> a.get(0)));

        return result;

    }

    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSumTwoPointers(int target, Node head) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(head == null || head.next == null)
            return result;

        Node tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }

        while(head != null && tail != null && head.data < tail.data) {
            int sum = head.data + tail.data;
            if(sum == target) {
                result.add(new ArrayList<>(List.of(head.data,tail.data)));
                head = head.next;
                tail = tail.prev;
            }else if(sum > target)
                tail =tail.prev;
            else head = head.next;
        }

        return result;

    }


}
