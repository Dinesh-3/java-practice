package stream.examples;


import stream.beans.Car;
import stream.mockdata.MockData;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingData {

    public void simpleGrouping() throws Exception {
        Map<String, List<Car>> map = MockData.getCars()
                .stream()
                .collect(Collectors.groupingBy(Car::getMake));
        map.forEach((s, cars) -> {
            System.out.println("Make " + s);
            cars.forEach(System.out::println);
            System.out.println("---------------------");
        });

    }

    public void groupingAndCounting() throws Exception {
        List<String> names = List.of(
                "John",
                "John",
                "Mariam",
                "Alex",
                "Mohammado",
                "Mohammado",
                "Vincent",
                "Alex",
                "Alex"
        );

        Map<String, Long> map = names.stream()
                .collect(Collectors.groupingBy(
//                        (result) -> result,
                        Function.identity(),
                        Collectors.counting())
                );

        System.out.println(map);

    }

}