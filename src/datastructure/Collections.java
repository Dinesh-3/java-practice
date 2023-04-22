package datastructure;

import java.util.*;
import java.util.HashMap;
import java.util.Stack;

public class Collections {
    public static void main() {
        String balance = "{ch(e}ck";

        var concat = balance.concat("dinesh");
        var isBalanced = isBalanced(balance);
//        System.out.println(isBalanced);
//        queuePractice();
        hashMapPractice();
    }

    private static boolean isBalanced(String balance) {
        Stack<Character> stack = new Stack<>();
        for(Character c: balance.toCharArray()){
            if(c == '(') stack.push(c);
            if(c == ')') {
                if(stack.empty()) return false;
                stack.pop();
            };
        }
        return stack.empty();
    }

    public static void queuePractice() {
        Queue<Integer> integers = new ArrayDeque<>();

        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
//        System.out.println(integers);
        System.out.println(reverseQueue(integers));

    }

    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Queue<Integer> newQueue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack();
        while (!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while (!stack.empty()){
            newQueue.add(stack.pop());
        }
        return newQueue;
    }

    public static void hashMapPractice() {

        String content = "a green apple";
        var result = getFirstNonRepeatChar(content);
        var firstRepeated = getFirstRepeatedChar(content);
        System.out.println("firstRepeated = " + firstRepeated);
        System.out.println("result = " + result);
    }

    private static char getFirstNonRepeatChar(String content) {
        Map<Character, Integer> hash = new HashMap<>();

        var characters = content.toCharArray();
        for (char item: characters) {
            var count = hash.getOrDefault(item, 0);
            hash.put(item, count + 1);
        }

        for(var character: characters){
            if(hash.get(character) == 1)
                return character;
        }
        return Character.MIN_VALUE;
    }

    private static char getFirstRepeatedChar(String content) {
        Set<Character> set = new HashSet<>();
        for(var item: content.toCharArray()){
            if(set.contains(item)) return item;
            set.add(item);
        }
        return Character.MIN_VALUE;
    }

}
