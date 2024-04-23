package com.dinesh.algorithm.leetcode75;
import java.util.*;

public class Dota2SenateQueue {


    public static void main(String[] args) {
        String senate = "RDD";
        String partyVictory = predictPartyVictory(senate);
        System.out.println("partyVictory = " + partyVictory);
    }
    public static String predictPartyVictory(String senate) {
        Queue<Integer> R = new ArrayDeque<>();
        Queue<Integer> D = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            char letter = senate.charAt(i);
            if(letter == 'R')
                R.add(i);
            else
                D.add(i);
        }

        while(!R.isEmpty() && !D.isEmpty()) {
            Integer r = R.remove();
            Integer d = D.remove();
            if(r < d)
                R.add(d + senate.length());
            else
                D.add(r + senate.length());
        }

        return D.isEmpty() ? "Radiant" : "Dire";

    }
}
