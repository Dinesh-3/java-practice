package com.dinesh.algorithm.leetcode75;

import java.util.Stack;

/**
 * 735. Asteroid Collision
 */
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = { -2, -1, 1, 2 };
        int[] ints = asteroidCollision(asteroids);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            stack.push(asteroid);
            if (asteroid < 0) {
                while (!stack.isEmpty()) {
                    int poped = stack.pop();
                    if(stack.isEmpty() || stack.peek() < 0)
                    {
                        stack.push(poped);
                        break;
                    }
                    if (stack.peek() < Math.abs(poped)) {
                        stack.pop();
                        stack.push(poped);
                    } else if(stack.peek() == Math.abs(poped)) {
                        stack.pop();
                        break;
                    } else
                        break;
                }
            }
        }

        int size = stack.size();
        int[] result = new int[size];
        for (int i = size - 1; i >= 0 ; i--)
            result[i] = stack.pop();

        return result;
    }
}
