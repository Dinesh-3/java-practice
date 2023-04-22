package stream.examples;

import stream.beans.Person;
import stream.mockdata.MockData;

import java.util.List;
import java.util.stream.Collectors;

public class HowStreamsWork {
    public void understandingCollect() throws Exception {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());

        emails.forEach(System.out::println);
    }

    public void intermediateAndTerminalOperations() throws Exception {
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 50_00_000;
                        })
                        .map(car -> {
                            System.out.println("mapping car " + car);
                            return car.getPrice();
                        })
                        .map(price -> {
                            System.out.println("mapping price " + price);
                            return price + (price * .14);
                        })
                        .collect(Collectors.toList())
        );
    }
}
