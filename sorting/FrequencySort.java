package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FrequencySort {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(3, 2, 5, 4, 1, 3, 4, 6, 5, 2, 8, 7, 4, 3, 6, 5, 2, 8, 3, 4, 6, 5, 8, 7, 2, 3, 5));

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int number: numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 1) + 1);
        }

        numbers.sort((current, other) -> {
            int diff = frequencyMap.get(current) - frequencyMap.get(other);
            if (diff == 0) return current - other;
            return diff;
        });

        System.out.println("numbers = " + numbers);

    }
}
