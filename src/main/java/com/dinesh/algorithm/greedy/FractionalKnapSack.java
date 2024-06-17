package com.dinesh.algorithm.greedy;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

/**
 * https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
 *
 * https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/
 * https://www.youtube.com/watch?v=1ibsQrnuEEg
 *
 */
public class FractionalKnapSack {
    public static void main(String[] args) {
        int n = 3;
        int w = 50;
        Item[] arr = { new Item(100, 20), new Item(60, 10), new Item(120, 30) };

        FractionalKnapSack knapSack = new FractionalKnapSack();
        knapSack.fractionalKnapsack(w, arr, n);
    }
    static class itemComparator implements Comparator<Item>
    {
        @Override
        public int compare(Item a, Item b)
        {
            double r1 = (double)(a.value) / (double)(a.weight);
            double r2 = (double)(b.value) / (double)(b.weight);
            if(r1 < r2) return 1;
            else if(r1 > r2) return -1;
            else return 0;
        }
    }

    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item[] arr, int n) {
        Arrays.sort(arr, new itemComparator());

        double total = 0;
        for (int i = 0; i < arr.length; i++) {
            Item item = arr[i];

            if(item.weight <= w) {
                total += item.value;
                w -= item.weight;
            } else {
                total = total + ((double) item.value / item.weight ) * w;
                w = 0;
                break;
            }
        }

        return total;
    }

}
