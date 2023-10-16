package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] words = {1,2,3};

        List<List<Integer>> perm = new ArrayList<>();
        perm.add(new ArrayList<>(List.of(words[0])));

        for (int i = 1; i < words.length; i++) {
            List<List<Integer>> permed = new ArrayList<>();
            for(List<Integer> sub: perm) {
                sub.add(words[i]);
                permed.add(sub);
            }
            for(List<Integer> newd: permed){
                perm.add(newd);
            }
        }
        System.out.println("perm = " + perm);
    }
}
