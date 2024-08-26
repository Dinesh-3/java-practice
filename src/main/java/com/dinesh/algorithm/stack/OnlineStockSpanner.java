package com.dinesh.algorithm.stack;

import java.util.*;

/**
 *
 * 901. Online Stock Span
 * https://leetcode.com/problems/online-stock-span/
 *
 * https://www.youtube.com/watch?v=eay-zoSRkVc
 *
 */
public class OnlineStockSpanner {
    List<Integer> list = new ArrayList<>();
    public OnlineStockSpanner() {

    }

//    public int next(int price) {
//
//        list.add(price);
//
//        while(!stack.isEmpty() && list.get(stack.peek()) <= price)
//            stack.pop();
//        int index = list.size()-1;
//        int next = index - (stack.isEmpty() ? -1 : stack.peek());
//        stack.push(index);
//        return next;
//    }

    class Node {
        int index;
        int number;
        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
    Stack<Node> stack = new Stack<>();
    int index = 0;

    public int next(int price) {
        while(!stack.isEmpty() && stack.peek().number <= price)
            stack.pop();
        int next = index - (stack.isEmpty() ? -1 : stack.peek().index);
        stack.push(new Node(index, price));
        index++;
        return next;
    }
}
