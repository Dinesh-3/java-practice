package stream.examples;

import stream.beans.Car;
import stream.beans.Person;
import stream.mockdata.MockData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnderstandingStreams {
    public static void main(String[] args) throws Exception {
        UnderstandingStreams streams = new UnderstandingStreams();
        streams.collect();
        streams.lazy();
    }
    void collect() throws IOException {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(
                        () -> new ArrayList<String>(),
                        (strings, e) -> strings.add(e),
                        (strings1, c) -> strings1.addAll(c)
                );
        System.out.println("emails = " + emails);
    }

    public void lazy() throws Exception {
        System.out.println(
                MockData.getCars()
                        .stream()
                        .filter(car -> {
                            System.out.println("filter car " + car);
                            return car.getPrice() < 10000;
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