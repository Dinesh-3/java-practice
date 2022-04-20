package datastructure.set;

import java.util.Set;

public class Util {
    public static void main(String[] args) {
        Set<String> first = Set.of("A", "B", "S", "Z");
        Set<String> second = Set.of("Q", "C", "K", "S");

        boolean match = first.stream().anyMatch(second::contains);
        System.out.println("match = " + match);

        boolean retainAll = first.retainAll(second);
        System.out.println("retainAll = " + retainAll);
    }

}
